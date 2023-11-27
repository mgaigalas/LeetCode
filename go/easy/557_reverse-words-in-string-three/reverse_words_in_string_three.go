// Package revwordsinstrthree contains solution for LeetCode problem: #557. Reverse Words in a String III.
package revwordsinstrthree

// reverseWords reverses the order of characters in each word within a sentence while still preserving
// whitespace and initial word order.
func reverseWords(s string) string {
	var left int
	res := []rune(s)
	for right := 0; right < len(s); right++ {
		if res[right] == ' ' {
			swapChars(res, left, right-1)
			left = right + 1
			continue
		}

		if right == len(s)-1 {
			swapChars(res, left, right)
		}
	}
	return string(res)
}

// swapChars swaps runes within provided 2 pointers.
func swapChars(res []rune, left int, right int) {
	for left < right {
		res[left], res[right] = res[right], res[left]
		left++
		right--
	}
}
