// Package sortcharsbyfreq contains solution for LeetCode problem: #451. Sort Characters By Frequency.
package sortcharsbyfreq

import (
	"strings"
)

// frequencySort given a string s, sort it in decreasing order based on the frequency of the characters.
// The frequency of a character is the number of times it appears in the string.
// Returns the sorted string. If there are multiple answers, return any of them.
func frequencySort(s string) string {
	charMap, maxCount := make(map[rune]int, len(s)), 0
	for _, c := range s {
		charMap[c]++
		maxCount = max(maxCount, charMap[c])
	}

	bucketMap := make(map[int][]rune, maxCount)
	for k, v := range charMap {
		if _, ok := bucketMap[v]; !ok {
			bucket := make([]rune, 0, maxCount)
			bucketMap[v] = append(bucket, k)
			continue
		}
		bucketMap[v] = append(bucketMap[v], k)
	}

	var sb strings.Builder
	for i := maxCount; i != 0; i-- {
		if bucket, ok := bucketMap[i]; ok {
			for _, char := range bucket {
				for j := 0; j < i; j++ {
					sb.WriteRune(char)
				}
			}
		}
	}
	return sb.String()
}
