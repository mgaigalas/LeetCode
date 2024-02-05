// Package findsmallestdivisorgiventhreshold contains solution for LeetCode problem:
// #1283. Find the Smallest Divisor Given a Threshold.
package findsmallestdivisorgiventhreshold

import "math"

// smallestDivisor finds the smallest divisor such that the result mentioned above is less than or equal to threshold.
func smallestDivisor(nums []int, threshold int) int {
	limit := float64(threshold)
	left, right := 1, 0
	for _, val := range nums {
		right = max(right, val)
	}

	for left <= right {
		mid := left + (right-left)/2
		if isValid(float64(mid), limit, nums) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return left
}

func isValid(divisor, limit float64, nums []int) bool {
	var sum float64
	for _, val := range nums {
		sum += math.Ceil(float64(val) / divisor)
	}

	if sum <= limit {
		return true
	}
	return false
}
