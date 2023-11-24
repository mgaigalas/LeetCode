// Package minvalforgetposstpbystpsum contains solution for LeetCode problem: #1413. Minimum Value to Get Positive Step by Step Sum.
package minvalforgetposstpbystpsum

// minStartValue returns minimum positive value of startValue such that the step by step sum is never less than 1.
func minStartValue(nums []int) int {
	curr, res := 0, 0
	for i := 0; i < len(nums); i++ {
		curr += nums[i]
		res = min(res, curr)
	}
	return 1 - res
}
