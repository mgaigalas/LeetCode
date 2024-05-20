// Package snakesandladders contains solution for LeetCode problem: #909. Snakes and Ladders.
package snakesandladders

// State contains data about current step within BFS.
type State struct {
	square, steps int
}

// snakesAndLadders returns the least number of moves required to reach the square n2.
// If it is not possible to reach the square, returns -1.
func snakesAndLadders(board [][]int) int {
	n := len(board)

	// reverse board for easier square-to-pos conversion later
	for i, j := 0, n-1; i < j; i, j = i+1, j-1 {
		board[i], board[j] = board[j], board[i]
	}

	queue := make([]*State, 1, n*n-1)
	queue[0] = &State{
		square: 1,
		steps:  0,
	}
	visited := make(map[int]struct{}, n*n-1)
	visited[1] = struct{}{}

	// BFS
	for len(queue) > 0 {
		state := queue[0]
		queue = queue[1:]

		for i := 1; i <= 6; i++ {
			nextSquare := state.square + i
			row, col := squareToPos(nextSquare, n)
			if val := board[row][col]; val != -1 {
				nextSquare = val
			}

			if nextSquare == n*n {
				return 1 + state.steps
			}

			if _, exists := visited[nextSquare]; !exists {
				visited[nextSquare] = struct{}{}
				queue = append(queue, &State{
					square: nextSquare,
					steps:  1 + state.steps,
				})
			}
		}
	}
	return -1
}

func squareToPos(square int, n int) (row, col int) {
	row = (square - 1) / n
	col = (square - 1) % n
	if row%2 != 0 {
		col = n - 1 - col
	}
	return row, col
}
