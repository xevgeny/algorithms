/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Standart BFS solution with queue
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>() {{
            offer(root);
        }};
        
        while (!q.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                level.add(q.poll().val);
            } 
            res.add(level);
        }
        
        return res;
    }
}