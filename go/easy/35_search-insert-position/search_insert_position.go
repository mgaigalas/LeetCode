// Package searchinsertposition contains solution for LeetCode problem: #35. Search Insert Position.
package searchinsertposition

// searchInsert given a sorted array of distinct integers and a target value, returns the index if the target is found.
// If not, returns the index where it would be if it were inserted in order.
func searchInsert(nums []int, target int) int {
	left, right := 0, len(nums)
	for left < right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		}

		if nums[mid] > target {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}
