/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
//
// For this problem, a path is defined as any sequence of nodes 
// from some starting node to any node in the tree along the parent-child connections.
// The path must contain at least one node and does not need to go through the root.
//
// e.g arbitrary path from one node to antoher

class Solution {
    private int maxVal = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        max(root);
        return maxVal;
    }
    
    private int max(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, max(node.left));   // does the left path contributes positively
        int right = Math.max(0, max(node.right)); // same for the right path
        maxVal = Math.max(maxVal, node.val + left + right);
        return node.val + Math.max(left, right);  // choosing either left or right or none 
    }
}
