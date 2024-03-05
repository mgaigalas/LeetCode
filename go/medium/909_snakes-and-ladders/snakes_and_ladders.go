// Package snakesandladders contains solution for LeetCode problem: #909. Snakes and Ladders.
package snakesandladders

type State struct {
	square, turns int
}

// snakesAndLadders returns the least number of moves required to reach the square n2.
// If it is not possible to reach the square, returns -1.
func snakesAndLadders(board [][]int) int {
	n := len(board)
	queue := make([]*State, 1, n*n+1)
	visited := make(map[int]struct{}, n*n+1)

	// reverse board so that start would be at [0, 0] and end would be at [n, n]
	for i, j := 0, n-1; i < j; i, j = i+1, j-1 {
		board[i], board[j] = board[j], board[i]
	}

	queue[0] = &State{
		square: 1,
		turns:  0,
	}
	visited[1] = struct{}{}

	// BFS
	for len(queue) > 0 {
		state := queue[0]
		queue = queue[1:]

		for i := 1; i <= 6; i++ {
			nextSquare := state.square + i
			if nextSquare > n*n {
				continue
			}

			row, col := squareToPos(nextSquare, n)
			if val := board[row][col]; val != -1 {
				nextSquare = val
			}

			if nextSquare == n*n {
				return 1 + state.turns
			}

			if _, exist := visited[nextSquare]; !exist {
				visited[nextSquare] = struct{}{}
				queue = append(queue, &State{
					square: nextSquare,
					turns:  1 + state.turns,
				})
			}
		}
	}
	return -1
}

func squareToPos(square, n int) (row, col int) {
	// no explicit conversion and floor ops needed as in Go division of two ints results in floor result
	row = (square - 1) / n
	col = (square - 1) % n
	if row%2 != 0 { // check if row is even (contains reversed order)
		col = n - 1 - col
	}
	return row, col
}
