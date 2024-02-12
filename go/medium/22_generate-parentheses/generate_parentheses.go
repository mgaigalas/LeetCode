// Package generateparentheses contains solution for LeetCode problem: #22. Generate Parentheses.
package generateparentheses

// generateParenthesis given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
func generateParenthesis(n int) []string {
	res := make([]string, 0)
	paths := make([]byte, 0, 2*n)
	var backtrack func(left, right int)
	backtrack = func(left, right int) {
		if len(paths) == 2*n {
			res = append(res, string(paths))
			return
		}

		if left < n {
			paths = append(paths, byte('('))
			backtrack(left+1, right)
			paths = paths[:len(paths)-1]
		}

		if left > right {
			paths = append(paths, byte(')'))
			backtrack(left, right+1)
			paths = paths[:len(paths)-1]
		}
	}
	backtrack(0, 0)
	return res
}
