// Package oddevenlinkedlist contains solution for LeetCode problem: #328. Odd Even Linked List.
package oddevenlinkedlist

// ListNode is a struct representing singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// oddEvenList given the head of a singly linked list, groups all the nodes with odd indices together
// followed by the nodes with even indices, and returns the reordered list.
func oddEvenList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	odd, even := head, head.Next
	evenHead := even
	for even != nil && even.Next != nil {
		odd.Next = even.Next
		odd = odd.Next

		even.Next = odd.Next
		even = even.Next
	}
	odd.Next = evenHead

	return head
}
