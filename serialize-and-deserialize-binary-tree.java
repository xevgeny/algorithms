/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Short Java solution: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74417/Short-and-clear-recursive-Java-solution
 * 
 * Solution:
 *  Idea here is to use recursion for serialization and deserialization.
 *  Note: this is not standard binary tree encoding.
 * 
 * [1,2,3,null,null,4,5] -> 1,2,null,null,3,4,null,null,5,null,null,
 * 
 */

public class Codec {
    private static final String NULL = "null";  
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        serialize(root, sb);
        // System.out.println(sb.toString());
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) sb.append(NULL + ",");
        else {
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        
        Queue<Integer> q = new LinkedList<>();
        for (String str : data.split(",")) {
            if (str.equals(NULL)) q.offer(null);
            else q.offer(Integer.parseInt(str));
        }
        
        TreeNode root = new TreeNode(q.poll());
        root.left = deserialize(root, q);
        root.right = deserialize(root, q);
        return root;
    }
    
    private TreeNode deserialize(TreeNode root, Queue<Integer> q) {
        Integer i = q.poll();
        if (q.isEmpty() || i == null) return null;
        else {
            TreeNode node = new TreeNode(i);
            node.left = deserialize(node, q);
            node.right = deserialize(node, q);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));