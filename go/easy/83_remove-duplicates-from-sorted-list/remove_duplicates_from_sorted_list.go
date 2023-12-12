// Package remduplfromsortlist contains solution for LeetCode problem: #83. Remove Duplicates from Sorted List.
package remduplfromsortlist

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// deleteDuplicates given the head of a sorted linked list, deletes all duplicates such that each element appears
// only once. Returns the linked list sorted as well.
func deleteDuplicates(head *ListNode) *ListNode {
	node := head
	for node != nil && node.Next != nil {
		if node.Val == node.Next.Val {
			node.Next = node.Next.Next
		} else {
			node = node.Next
		}
	}
	return head
}
