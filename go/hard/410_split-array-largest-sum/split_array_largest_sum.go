// Package splitarraylargestsum contains solution for LeetCode problem: #410. Split Array Largest Sum.
package splitarraylargestsum

// splitArray returns the minimized largest sum of the split.
func splitArray(nums []int, k int) int {
	var left, right int
	for _, val := range nums {
		left = max(left, val)
		right += val
	}

	var largestSumAmongSubArrays int
	for left <= right {
		maxAllowedSum := left + (right-left)/2
		if numberOfSubArraysRequired(nums, maxAllowedSum) <= k {
			largestSumAmongSubArrays = maxAllowedSum
			right = maxAllowedSum - 1
		} else {
			left = maxAllowedSum + 1
		}
	}
	return largestSumAmongSubArrays
}

func numberOfSubArraysRequired(nums []int, maxAllowedSum int) int {
	var sum, subArrayCount int
	for _, val := range nums {
		if sum+val <= maxAllowedSum {
			sum += val
			continue
		}
		subArrayCount++
		sum = val
	}
	return subArrayCount + 1
}
