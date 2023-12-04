// Package largestuniquenumber contains solution for LeetCode problem: #1133. Largest Unique Number.
package largestuniquenumber

// largestUniqueNumber given an integer array nums, returns the largest integer that only occurs once.
// If no integer occurs once, returns -1.
func largestUniqueNumber(nums []int) int {
	m, mn := make(map[int]int, len(nums)), 0
	for _, n := range nums {
		m[n] += 1
		mn = max(mn, n)
	}

	for i := mn; i >= 0; i-- {
		if m[i] == 1 {
			return i
		}
	}
	return -1
}
