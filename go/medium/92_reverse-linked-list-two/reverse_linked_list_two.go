// Package reverselinkedlisttwo contains solution for LeetCode problem: #92. Reverse Linked List II.
package reverselinkedlisttwo

// ListNode is a struct representing singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// reverseBetween given the head of a singly linked list and two integers left and right where left <= right, reverses
// the nodes of the list from position left to position right, and returns the reversed list.
func reverseBetween(head *ListNode, left int, right int) *ListNode {
	dummy := &ListNode{
		Val:  -1,
		Next: head,
	}
	before := dummy
	for i := 1; i < left; i++ {
		before = before.Next
	}

	prev := before
	curr := before.Next
	for i := left; i <= right; i++ {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}

	before.Next.Next = curr
	before.Next = prev

	return dummy.Next
}
