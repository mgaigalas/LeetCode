// Package revstr contains solution for LeetCode problem: #344. Reverse String.
package revstr

// reverseString is a function that reverses a string.
func reverseString(s []byte) {
	left, right := 0, len(s)-1
	for left < right {
		s[left], s[right] = s[right], s[left]
		left++
		right--
	}
}
