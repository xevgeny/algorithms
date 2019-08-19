/*

Porblem: https://leetcode.com/problems/word-search-ii/submissions/
Solution (copied): https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)

Trie + dfs

*/


class Trie {
    Trie[] next = new Trie[26];
    String word;
}

class Solution {
     
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        Collections.sort(res);
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, Trie trie, List<String> res) {
        char c = board[i][j];
        
        if (c == '#' || trie.next[c - 'a'] == null) return; // Check on '#' first!
        Trie next = trie.next[c - 'a']; // Next leaf.

        if (next.word != null) { // We found a match!
            res.add(next.word);
            next.word = null; // Deduplication.
            // continue to the next possible word.
        }
        
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, next, res);
        if (j > 0) dfs(board, i, j - 1, next, res);
        if (i < board.length - 1) dfs(board, i + 1, j, next, res);
        if (j < board[i].length - 1) dfs(board, i, j + 1, next, res);
        board[i][j] = c;
    }
    
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Trie();
                node = node.next[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }   
}