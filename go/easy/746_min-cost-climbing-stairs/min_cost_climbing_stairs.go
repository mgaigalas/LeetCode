// Package mincostclimbingstairs contains solution for LeetCode problem: #746. Min Cost Climbing Stairs.
package mincostclimbingstairs

// minCostClimbingStairs returns the minimum cost to reach the top of the floor.
func minCostClimbingStairs(cost []int) int {
	var prevOne, prevTwo int
	for i := 2; i <= len(cost); i++ {
		tmp := prevOne
		prevOne = min(prevOne+cost[i-1], prevTwo+cost[i-2])
		prevTwo = tmp
	}
	return prevOne
}
