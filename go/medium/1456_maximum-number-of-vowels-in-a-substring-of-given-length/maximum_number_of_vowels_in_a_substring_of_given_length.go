// Package findpivotindex contains solution for LeetCode problem: #1456. Maximum Number of Vowels in a Substring of
// Given Length.
package maxnumofvowelsinsubstrofgivenlength

// maxVowels given a string s and an integer k, returns the maximum number of vowel letters in
// any substring of s with length k.
func maxVowels(s string, k int) int {
	var left, count, res int
	for right := 0; right < len(s); right++ {
		if right-left > k-1 {
			if isVowel(s[left]) {
				count--
			}
			left++
		}

		if isVowel(s[right]) {
			count++
		}
		res = max(res, count)
	}
	return res
}

func isVowel(char uint8) bool {
	switch char {
	case 97, 101, 105, 111, 117:
		return true
	default:
		return false
	}
}
