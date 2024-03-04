// Package uniquepathstwo contains solution for LeetCode problem: #63. Unique Paths II.
package uniquepathstwo

// uniquePathsWithObstacles returns the number of possible unique paths that the robot can take to reach
// the bottom-right corner.
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	n := len(obstacleGrid)
	m := len(obstacleGrid[0])
	memo := make([][]int, n)
	for i := 0; i < n; i++ {
		mem := make([]int, m)
		for j := 0; j < m; j++ {
			mem[j] = -1
		}
		memo[i] = mem
	}

	var dp func(row, col int) int
	dp = func(row, col int) int {
		if val := obstacleGrid[row][col]; val == 1 {
			return 0
		}

		if row+col == 0 {
			return 1
		}

		if val := memo[row][col]; val != -1 {
			return val
		}

		var res int
		if row > 0 {
			res += dp(row-1, col)
		}

		if col > 0 {
			res += dp(row, col-1)
		}
		memo[row][col] = res
		return res
	}
	return dp(m-1, n-1)
}
