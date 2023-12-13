// Package deletemidnodeoflinkedlist contains solution for LeetCode problem: #2095. Delete the Middle Node of a
// Linked List.
package deletemidnodeoflinkedlist

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// deleteMiddle given the head of a linked list - deletes the middle node, and returns the head of
// the modified linked list.
func deleteMiddle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}

	slow, fast := head, head.Next.Next
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	slow.Next = slow.Next.Next

	return head
}
