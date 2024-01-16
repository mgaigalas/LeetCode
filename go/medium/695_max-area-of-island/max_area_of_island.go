// Package maxareaofisland contains solution for LeetCode problem: #695. Max Area of Island.
package maxareaofisland

// maxAreaOfIsland returns the maximum area of an island in grid. If there is no island, returns 0.
func maxAreaOfIsland(grid [][]int) int {
	var res int
	for row := 0; row < len(grid); row++ {
		for col := 0; col < len(grid[0]); col++ {
			res = max(res, dfs(grid, row, col))
		}
	}
	return res
}

func dfs(grid [][]int, row, col int) int {
	if row < 0 || row >= len(grid) ||
		col < 0 || col >= len(grid[0]) ||
		grid[row][col] == 0 {
		return 0
	}
	// this is replacement for "seen" tracking
	grid[row][col] = 0

	return 1 +
		dfs(grid, row+1, col) +
		dfs(grid, row-1, col) +
		dfs(grid, row, col+1) +
		dfs(grid, row, col-1)
}
