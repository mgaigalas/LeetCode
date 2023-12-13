// Package middleoflinkedlist contains solution for LeetCode problem: #876. Middle of the Linked List.
package convbinarynuminlinkedlsttoint

// Definition for singly-linked list.
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
