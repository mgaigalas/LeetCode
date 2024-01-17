// Package nearestexitfromentranceinmaze contains solution for LeetCode problem:
// #1926. Nearest Exit from Entrance in Maze.
package nearestexitfromentranceinmaze

type State struct {
	row, col int
	steps    int
}

// nearestExit returns the number of steps in the shortest path from the entrance to the nearest exit,
// or -1 if no such path exists.
func nearestExit(maze [][]byte, entrance []int) int {
	directions := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
	m := len(maze)
	n := len(maze[0])
	seen := make([][]bool, m)
	seenSpace := make([]bool, m*n)
	for i := 0; i < m; i++ {
		seen[i] = seenSpace[i*n : (i+1)*n]
	}

	queue := make([]*State, 1, n)
	seen[entrance[0]][entrance[1]] = true
	queue[0] = &State{
		row:   entrance[0],
		col:   entrance[1],
		steps: 0,
	}

	for len(queue) > 0 {
		state := queue[0]
		queue = queue[1:]

		row := state.row
		col := state.col
		steps := state.steps
		if (row == m-1 || col == n-1 || row == 0 || col == 0) &&
			steps != 0 {
			return steps
		}

		for _, direction := range directions {
			nextRow, nextCol := row+direction[0], col+direction[1]
			if valid(nextRow, nextCol, maze) && !seen[nextRow][nextCol] {
				seen[nextRow][nextCol] = true
				queue = append(queue, &State{
					row:   nextRow,
					col:   nextCol,
					steps: steps + 1,
				})
			}
		}
	}
	return -1
}

func valid(row int, col int, maze [][]byte) bool {
	if row < 0 || row >= len(maze) ||
		col < 0 || col >= len(maze[0]) ||
		maze[row][col] == '+' {
		return false
	}
	return true
}
