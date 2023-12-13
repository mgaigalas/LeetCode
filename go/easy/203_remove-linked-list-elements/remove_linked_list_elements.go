// Package rmlinkedlistelements contains solution for LeetCode problem: #203. Remove Linked List Elements.
package rmlinkedlistelements

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// removeElements given the head of a linked list and an integer val, removes all the nodes of the linked list that
// has Node.val == val, and returns the new head.
func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return nil
	}

	dummy := &ListNode{
		Val:  -1,
		Next: head,
	}

	prev := dummy
	curr := dummy.Next
	for curr != nil {
		if curr.Val == val {
			prev.Next = prev.Next.Next
		} else {
			prev = curr
		}
		curr = curr.Next
	}

	return dummy.Next
}
