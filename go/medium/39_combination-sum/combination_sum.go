// Package combinationsum contains solution for LeetCode problem: #39. Combination Sum.
package combinationsum

// combinationSum given an array of distinct integers candidates and a target integer target, returns a
// list of all unique combinations of candidates where the chosen numbers sum to target.
func combinationSum(candidates []int, target int) [][]int {
	res := make([][]int, 0)
	path := make([]int, 0)
	var backtrack func(start int, sum int)
	backtrack = func(start int, sum int) {
		if sum == target {
			resVal := make([]int, len(path))
			copy(resVal, path)
			res = append(res, resVal)
			return
		}

		for i := start; i < len(candidates); i++ {
			nextSum := sum + candidates[i]
			if nextSum > target {
				continue
			}
			path = append(path, candidates[i])
			backtrack(i, nextSum)
			path = path[:len(path)-1]
		}
	}
	backtrack(0, 0)
	return res
}
