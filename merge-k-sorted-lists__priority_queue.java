
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Time complexity O(kNlogN)
// Reusing ListNodes pointers

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode ln : lists) {
            while (ln != null) {
                pq.add(ln);
                ln = ln.next;
            }
        }

        if (pq.isEmpty())
            return null;

        ListNode head = pq.poll();
        ListNode curr = head;

        while (!pq.isEmpty()) {
            ListNode ln = pq.poll();
            curr.next = ln;
            curr = ln;
        }

        curr.next = null;
        return head;
    }
}