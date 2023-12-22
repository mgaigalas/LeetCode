// Package palindromelinkedlist contains solution for LeetCode problem: #234. Palindrome Linked List.
package palindromelinkedlist

// ListNode is a struct representing singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// isPalindrome given the head of a singly linked list, returns true if it is a palindrome
// or false otherwise.
func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}

	firstHalfTail := findMiddleNode(head)
	reversedSecondHalfHead := reverseNode(firstHalfTail.Next)
	return areEqual(head, reversedSecondHalfHead)
}

// findMiddleNode finds and returns middle node of a linked list.
func findMiddleNode(node *ListNode) *ListNode {
	slow, fast := node, node
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

// reverseNode reverses linked list node starting from starting node.
func reverseNode(node *ListNode) *ListNode {
	var prev *ListNode
	curr := node
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	return prev
}

// areEqual compares p1 and p2 linked list nodes for equality based on their values.
func areEqual(p1, p2 *ListNode) bool {
	for p2 != nil {
		if p1.Val != p2.Val {
			return false
		}
		p1 = p1.Next
		p2 = p2.Next
	}
	return true
}
