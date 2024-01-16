# #695. Max Area of Island

<p>You are given an <code>m x n</code> binary matrix <code>grid</code>. An island is a group of <code>1</code>'s (representing land) connected <strong>4-directionally</strong> (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.</p>

<p>The <strong>area</strong> of an island is the number of cells with a value <code>1</code> in the island.</p>

<p>Return <em>the maximum <strong>area</strong> of an island in </em><code>grid</code>. If there is no island, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="ex1.jpg" style="width: 500px; height: 310px;">
<pre><strong>Input:</strong> grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The answer is not 11, because the island must be connected 4-directionally.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[0,0,0,0,0,0,0,0]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

## Notes

This problem can be solved by using "standard" approach using direction constraints. This solution uses a lot of 
redundant memory for travel tracking purposes, which is not needed as grid itself can be manipulated

```go
// Package maxareaofisland contains solution for LeetCode problem: #695. Max Area of Island.
package maxareaofisland

// maxAreaOfIsland returns the maximum area of an island in grid. If there is no island, returns 0.
func maxAreaOfIsland(grid [][]int) int {
	directions := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	m := len(grid)
	n := len(grid[0])

	seen := make([][]bool, m)
	seenRows := make([]bool, m*n)
	for i := 0; i < m; i++ {
		seen[i] = seenRows[i*n : (i+1)*n]
	}

	var res int
	for row := 0; row < m; row++ {
		for col := 0; col < n; col++ {
			if grid[row][col] == 1 && !seen[row][col] {
				seen[row][col] = true
				res = max(res, dfs(row, col, grid, directions, seen, m, n))
			}
		}
	}
	return res
}

func dfs(row int, col int, grid [][]int, directions [][]int, seen [][]bool, m int, n int) int {
	area := 1
	for _, direction := range directions {
		nextRow := row + direction[0]
		nextCol := col + direction[1]

		if valid(nextRow, nextCol, grid, m, n) && !seen[nextRow][nextCol] {
			seen[nextRow][nextCol] = true
			area += dfs(nextRow, nextCol, grid, directions, seen, m, n)
		}
	}
	return area
}

func valid(row int, col int, grid [][]int, m int, n int) bool {
	if row >= 0 && row < m &&
		col >= 0 && col < n &&
		grid[row][col] == 1 {
		return true
	}
	return false
}

```