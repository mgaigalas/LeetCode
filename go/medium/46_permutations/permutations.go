// Package permutations contains solution for LeetCode problem: #46. Permutations.
package permutations

import "slices"

// permute given an array nums of distinct integers, returns all the possible permutations.
func permute(nums []int) [][]int {
	res := make([][]int, 0, factorial(len(nums)))
	curr := make([]int, 0, len(nums))

	var backtrack func(curr []int)
	backtrack = func(curr []int) {
		if len(curr) == len(nums) {
			resVal := make([]int, 0, len(curr))
			resVal = append(resVal, curr...)
			res = append(res, resVal)
			return
		}

		for _, val := range nums {
			if !slices.Contains(curr, val) {
				curr = append(curr, val)
				backtrack(curr)
				curr = curr[:len(curr)-1]
			}
		}
	}
	backtrack(curr)
	return res
}

func factorial(number int) int {
	if number == 1 {
		return 1
	}
	return number * factorial(number-1)
}
