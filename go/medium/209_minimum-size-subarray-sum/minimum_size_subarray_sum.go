// Package revwordsinstrthree contains solution for LeetCode problem: 209. Minimum Size Subarray Sum.
package minsizesubarraysum

// minSubArrayLen returns the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.
func minSubArrayLen(target int, nums []int) int {
	var left, sum, res int
	for right := 0; right < len(nums); right++ {
		sum += nums[right]
		for sum >= target {
			if res == 0 {
				res = right - left + 1
			} else {
				res = min(res, right-left+1)
			}
			sum -= nums[left]
			left++
		}
	}
	return res
}
