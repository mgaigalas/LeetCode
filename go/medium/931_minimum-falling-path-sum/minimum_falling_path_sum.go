// Package minimumfallingpathsum contains solution for LeetCode problem: #931. Minimum Falling Path Sum.
package minimumfallingpathsum

import "math"

// minFallingPathSum returns the minimum sum of any falling path through matrix.
func minFallingPathSum(matrix [][]int) int {
	n := len(matrix)
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, n+1)
	}

	for row := n - 1; row >= 0; row-- {
		for col := 0; col < n; col++ {
			nextRow := dp[row+1][col]
			if col == 0 {
				dp[row][col] = min(nextRow, dp[row+1][col+1]) + matrix[row][col]
				continue
			}

			if col == n-1 {
				dp[row][col] = min(nextRow, dp[row+1][col-1]) + matrix[row][col]
				continue
			}

			dp[row][col] = min(nextRow, min(dp[row+1][col+1], dp[row+1][col-1])) + matrix[row][col]
		}
	}

	res := math.MaxInt64
	for col := 0; col < n; col++ {
		res = min(res, dp[0][col])
	}
	return res
}
