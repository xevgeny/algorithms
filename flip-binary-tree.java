/*

- https://www.geeksforgeeks.org/flip-binary-tree/
- https://medium.com/@jimdaosui/binary-tree-upside-down-77af203c79af

Binary Tree:

    1
   / \
  2   3
 / \
4   5

Flipped Binary Tree:

    1
   / 
  2 - 3
 / 
4 - 5

*/

import java.io.*;
import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

class Solution {

    public static Node flipBinaryTree(Node root) {
        if (root != null && root.left != null) {
            Node flipNode = flipBinaryTree(root.left);

            // Transformation on current node
            root.left.left = root.right;
            root.left.right = root;
            root.left = root.right = null;

            return flipNode;
        }
        return root;
    }

    private static void printTraverse(Node node) {
        System.out.println("Level traverse of " + node + ":");
        Queue<Node> q = new LinkedList<>();
        if (node != null) q.offer(node);
        String level = "";
        while (!q.isEmpty()) {
            level = "";
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                level += curr.val + " ";
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            System.out.println(level);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printTraverse(root);
        printTraverse(flipBinaryTree(root));
    }
}