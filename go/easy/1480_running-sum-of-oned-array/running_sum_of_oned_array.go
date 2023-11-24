// Package runningsumonedarray contains solution for LeetCode problem: #1480. Running Sum of 1d Array.
package runningsumonedarray

// runningSum given an array of nums returns the running sum of nums, where a running sum of an array as
// runningSum[i] = sum(nums[0]…nums[i]).
func runningSum(nums []int) []int {
	curr := nums[0]
	res := make([]int, len(nums))
	res[0] = curr
	for i := 1; i < len(nums); i++ {
		curr += nums[i]
		res[i] = curr
	}
	return res
}
