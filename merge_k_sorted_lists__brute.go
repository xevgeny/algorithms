/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

/*

Brute Force

    - Traverse all the linked lists and collect the values of the nodes into an array.
    - Sort and iterate over this array to get the proper value of nodes.
    - Create a new sorted linked list and extend it with the new nodes.

*/

import "sort"

func mergeKLists(lists []*ListNode) *ListNode {
	arr := []int{}
	for _, ln := range lists {
		for ln != nil {
			arr = append(arr, ln.Val)
			ln = ln.Next
		}
	}

	sort.Ints(arr)

	if len(arr) == 0 {
		return nil
	}

	head := &ListNode{arr[0], nil}
	curr := head
	for i := 1; i < len(arr); i++ {
		ln := &ListNode{arr[i], nil}
		curr.Next = ln
		curr = ln
	}

	return head
}
