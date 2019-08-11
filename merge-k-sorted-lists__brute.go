/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

// Brute force solution: merge k lists -> sort resulted array

import "sort"

func mergeKLists(lists []*ListNode) *ListNode {
	arr := []*ListNode{}
	for _, ln := range lists {
		for ln != nil {
			arr = append(arr, ln)
			ln = ln.Next
		}
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i].Val < arr[j].Val
	})

	if len(arr) == 0 {
		return nil
	}

	head := arr[0]
	curr := head

	for i := 1; i < len(arr); i++ {
		ln := arr[i]
		curr.Next = ln
		curr = ln
	}

	curr.Next = nil

	return head
}