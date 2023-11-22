// Package sqrsortarray contains solution for LeetCode problem: #977. Squares of a Sorted Array.
package sqrsortarray

// sortedSquares given an integer array nums sorted in non-decreasing order, returns an array of the squares of
// each number sorted in non-decreasing order.
func sortedSquares(nums []int) []int {
	res := make([]int, len(nums))
	left, right := 0, len(nums)-1
	idx := right
	for left <= right {
		leftVal := nums[left] * nums[left]
		rightVal := nums[right] * nums[right]
		if leftVal > rightVal {
			res[idx] = leftVal
			left++
		} else {
			res[idx] = rightVal
			right--
		}
		idx--
	}
	return res
}
