// Package combinations contains solution for LeetCode problem: #77. Combinations.
package combinations

// combine given two integers n and k, returns all possible combinations of k numbers chosen from the range [1, n].
func combine(n int, k int) [][]int {
	res := make([][]int, 0)
	curr := make([]int, 0, k)

	var backtrack func(i int)
	backtrack = func(i int) {
		if len(curr) == k {
			resVal := make([]int, k)
			copy(resVal, curr)
			res = append(res, resVal)
		}

		for j := i; j <= n; j++ {
			curr = append(curr, j)
			backtrack(j + 1)
			curr = curr[:len(curr)-1]
		}
	}
	backtrack(1)
	return res
}
