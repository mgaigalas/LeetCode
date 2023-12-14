// Package removenthnodefromendoflist contains solution for LeetCode problem: #19. Remove Nth Node From End of List.
package removenthnodefromendoflist

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// removeNthFromEnd given the head of a linked list, removes the nth node from the end of the list and returns its head.
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	curr := head
	for i := 0; i < n; i++ {
		curr = curr.Next
	}

	if curr == nil {
		return head.Next
	}

	prev := head
	for curr.Next != nil {
		curr = curr.Next
		prev = prev.Next
	}
	prev.Next = prev.Next.Next

	return head
}
