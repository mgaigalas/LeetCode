// Package subsets contains solution for LeetCode problem: #78. Subsets.
package subsets

// subsets given an integer array nums of unique elements, returns all possible subsets (the power set).
func subsets(nums []int) [][]int {
	res := make([][]int, 0)
	curr := make([]int, 0)

	var backtrack func(i int)
	backtrack = func(i int) {
		if i > len(nums) {
			return
		}
		resVal := make([]int, len(curr))
		copy(resVal, curr)
		res = append(res, resVal)

		for j := i; j < len(nums); j++ {
			curr = append(curr, nums[j])
			backtrack(j + 1)
			curr = curr[:len(curr)-1]
		}
	}
	backtrack(0)
	return res
}
