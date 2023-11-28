// Package findpivotindex contains solution for LeetCode problem: #724. Find Pivot Index.
package findpivotindex

// pivotIndex given an array of integers nums, calculates the pivot index of this array.
func pivotIndex(nums []int) int {
	var sum, leftSum int
	for _, val := range nums {
		sum += val
	}

	for idx, val := range nums {
		if leftSum == sum-leftSum-val {
			return idx
		}
		leftSum += val
	}
	return -1
}
