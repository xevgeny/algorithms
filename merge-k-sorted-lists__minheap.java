/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 Problem: 
 
 - https://leetcode.com/problems/merge-k-sorted-lists/
 
 Solutions:
 
 - https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
 - https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 
 1. brute force
    
    Merge all arrays, sort with stable sort - O(NklogNk)
 
 2. merge into groups of 2
 
    After first merging, we have k/2 arrays. We again merge arrays in groups, now we have k/4 arrays. We keep doing it unit we have one array left. The time complexity of this solution would O(Nklogk).
       
 3. min-heap of size k
 
    Same complexity - O(Nklogk). But for different sized arrays, this solution works much better.
 
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);        
        for (ListNode head : lists) { // initialize pq with head elements
            if (head != null) pq.offer(head);
        }
        if (pq.isEmpty()) return null;
        
        ListNode head = pq.peek();
        ListNode curr = head;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) pq.offer(node.next); // next node (from the same list)
            curr.next = node;
            curr = node;
        }
        
        curr.next = null;
        return head;
    }
}