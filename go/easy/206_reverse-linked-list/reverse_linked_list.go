// Package reverselinkedlist contains solution for LeetCode problem: #92. Reverse Linked List II.
package reverselinkedlist

// ListNode is a struct representing singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// reverseList given the head of a singly linked list, reverses the list, and returns the reversed list.
func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	var prev *ListNode
	curr := head
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	return prev
}
