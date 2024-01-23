// Package openthelock contains solution for LeetCode problem: #752. Open the Lock.
package openthelock

import "strings"

// State contains data about current step within BFS.
type State struct {
	code  string
	turns int
}

// openLock given a target representing the value of the wheels that will unlock the lock, returns the minimum
// total number of turns required to open the lock, or -1 if it is impossible.
func openLock(deadends []string, target string) int {
	seen := make(map[string]struct{})
	for _, deadEnd := range deadends {
		seen[deadEnd] = struct{}{}
	}

	queue := make([]*State, 1)
	queue[0] = &State{
		code:  "0000",
		turns: 0,
	}

	for len(queue) > 0 {
		state := queue[0]
		queue = queue[1:]
		code := state.code
		if code == target {
			return state.turns
		}

		for i := 0; i < 4; i++ {
			currDigit := int(code[i] - '0')
			for _, direction := range []int{-1, 1} {
				newDigit := (currDigit + direction + 10) % 10
				var sb strings.Builder
				sb.WriteString(code[:i])
				sb.WriteByte(byte(newDigit + '0'))
				sb.WriteString(code[i+1:])
				newCode := sb.String()
				if _, exists := seen[newCode]; exists {
					continue
				}

				seen[newCode] = struct{}{}
				queue = append(queue, &State{
					code:  newCode,
					turns: state.turns + 1,
				})
			}
		}
	}
	return -1
}
