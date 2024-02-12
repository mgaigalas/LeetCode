// Package numswithsameconsecdiffs contains solution for LeetCode problem:
// #967. Numbers With Same Consecutive Differences.
package numswithsameconsecdiffs

// numsSameConsecDiff given two integers n and k, returns an array of all the integers of length n where the difference
// between every two consecutive digits is k.
func numsSameConsecDiff(n int, k int) []int {
	res := make([]int, 0)
	var backtrack func(curr, digit, pos int)
	backtrack = func(curr, digit, pos int) {
		if pos == n {
			res = append(res, curr)
			return
		}

		for i := 0; i < 10; i++ {
			if curr == 0 && i == 0 {
				continue
			}
			if curr == 0 || digit-i == k || i-digit == k {
				backtrack(curr*10+i, i, pos+1)
			}
		}
	}
	backtrack(0, 0, 0)
	return res
}
