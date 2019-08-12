// https://leetcode.com/problems/top-k-frequent-words/
// If two words have the same frequency, then the word with the lower alphabetical order comes first.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() != b.getValue()) return b.getValue() - a.getValue(); // by frequency desc
            else return a.getKey().compareTo(b.getKey()); // lexicographical
        });
        pq.addAll(map.entrySet());
        
        List<String> res = new ArrayList(k);
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        
        return res;
    }
}
