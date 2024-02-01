// Package longestsubseqwithlimitedsum contains solution for LeetCode problem:
// #2389. Longest Subsequence With Limited Sum.
package longestsubseqwithlimitedsum

import "slices"

// answerQueries returns an array answer of length m where answer[i] is the maximum size of a subsequence that you
// can take from nums such that the sum of its elements is less than or equal to queries[i].
func answerQueries(nums []int, queries []int) []int {
	slices.Sort(nums)
	pfxSums := make([]int, len(nums))
	var pfxSum int
	for i := 0; i < len(nums); i++ {
		pfxSum += nums[i]
		pfxSums[i] = pfxSum
	}

	res := make([]int, 0, len(queries))
	for i := 0; i < len(queries); i++ {
		res = append(res, binarySearch(queries[i], pfxSums))
	}
	return res
}

func binarySearch(query int, nums []int) int {
	left, right := 0, len(nums)
	for left < right {
		mid := left + (right-left)/2
		if nums[mid] > query {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}
