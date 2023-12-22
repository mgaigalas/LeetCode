// Package convbinarynuminlinkedlsttoint contains solution for LeetCode problem: #1290. Convert Binary Number in a
// Linked List to Integer.
package convbinarynuminlinkedlsttoint

// ListNode is a struct representing singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// getDecimalValue returns the decimal value of the number in the linked list.
func getDecimalValue(head *ListNode) int {
	var num int
	for head != nil {
		num = (num << 1) | head.Val
		head = head.Next
	}
	return num
}
