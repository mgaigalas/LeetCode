// Package customsortstring contains solution for LeetCode problem: #791. Custom Sort String.
package customsortstring

import "strings"

// customSortString permutes the characters of s so that they match the order that order was sorted.
func customSortString(order string, s string) string {
	count := make([]int, 26)
	for _, c := range s {
		count[c-'a']++
	}

	var sb strings.Builder
	for _, c := range order {
		for i := 0; i < count[c-'a']; i++ {
			sb.WriteRune(c)
		}
		count[c-'a'] = 0
	}

	for i := 'a'; i <= 'z'; i++ {
		for j := 0; j < count[i-'a']; j++ {
			sb.WriteRune(i)
		}
	}

	return sb.String()
}
