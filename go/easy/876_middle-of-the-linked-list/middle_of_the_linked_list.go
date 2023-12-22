// Package middleoflinkedlist contains solution for LeetCode problem: #876. Middle of the Linked List.
package middleoflinkedlist

// ListNode is a struct representing singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// middleNode given the head of a singly linked list, returns the middle node of the linked list.
// If there are two middle nodes, return the second middle node.
func middleNode(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}
