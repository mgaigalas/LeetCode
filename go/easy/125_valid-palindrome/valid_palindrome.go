// Package validpalindrome contains solution for LeetCode problem: #125. Valid Palindrome.
package validpalindrome

// isPalindrome returns true if string s is a palindrome, or false otherwise.
func isPalindrome(s string) bool {
	var left, right = 0, len(s) - 1
	for left < right {
		for left < right && !isAlphanumeric(s[left]) {
			left++
		}

		for left < right && !isAlphanumeric(s[right]) {
			right--
		}

		if toLowerCase(s[left]) != toLowerCase(s[right]) {
			return false
		}

		left++
		right--
	}
	return true
}

func isAlphanumeric(char uint8) bool {
	return ('A' <= char && char <= 'Z') ||
		('a' <= char && char <= 'z') ||
		('0' <= char && char <= '9')
}

func toLowerCase(char uint8) uint8 {
	if 'A' <= char && char <= 'Z' {
		return char - 'A' + 'a'
	}
	return char
}
