// Package contiguousarray contains solution for LeetCode problem: #525. Contiguous Array.
package contiguousarray

// findMaxLength given a binary array nums, returns the maximum length of a contiguous subarray with an equal number
// of 0 and 1.
func findMaxLength(nums []int) int {
	sumToIndexMap := make(map[int]int, len(nums))
	sumToIndexMap[0] = -1

	var sum, maxLength int
	for i := 0; i < len(nums); i++ {
		if nums[i] == 1 {
			sum++
		} else {
			sum--
		}

		if idx, ok := sumToIndexMap[sum]; ok {
			maxLength = max(maxLength, i-idx)
		} else {
			sumToIndexMap[sum] = i
		}
	}
	return maxLength
}
