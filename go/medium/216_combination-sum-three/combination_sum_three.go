// Package combinationsumthree contains solution for LeetCode problem: #216. Combination Sum III.
package combinationsumthree

// combinationSum3 finds all valid combinations of k numbers that sum up to n such that the following conditions
// are true:
// Only numbers 1 through 9 are used.
// Each number is used at most once.
func combinationSum3(k int, n int) [][]int {
	numRange := n
	if numRange > 9 {
		numRange = 9
	}
	res := make([][]int, 0)
	paths := make([]int, 0)
	var backtrack func(start, sum int)
	backtrack = func(start, sum int) {
		if sum == n && len(paths) == k {
			resVal := make([]int, len(paths))
			copy(resVal, paths)
			res = append(res, resVal)
			return
		}

		if sum > n || len(paths) > k {
			return
		}

		for i := start; i <= numRange; i++ {
			paths = append(paths, i)
			backtrack(i+1, sum+i)
			paths = paths[:len(paths)-1]
		}
	}
	backtrack(1, 0)
	return res
}
