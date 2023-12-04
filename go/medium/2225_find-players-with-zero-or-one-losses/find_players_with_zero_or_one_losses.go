// Package findplayerswithzerooronelosses contains solution for LeetCode problem: #2225. Find Players With Zero or
// One Losses.
package findplayerswithzerooronelosses

import "sort"

func findWinners(matches [][]int) [][]int {
	wins := make([]int, 0, len(matches))
	losses := make([]int, 0, len(matches))

	lostMatches := make(map[int]int, len(matches))
	for i := 0; i < len(matches); i++ {
		if _, ok := lostMatches[matches[i][0]]; !ok {
			lostMatches[matches[i][0]] = 0
		}
		lostMatches[matches[i][1]] += 1
	}

	for player, lossCount := range lostMatches {
		if lossCount == 0 {
			wins = append(wins, player)
			continue
		}

		if lossCount == 1 {
			losses = append(losses, player)
		}
	}

	sort.Ints(wins)
	sort.Ints(losses)

	res := make([][]int, 2, 2)
	res[0] = wins
	res[1] = losses
	return res
}
