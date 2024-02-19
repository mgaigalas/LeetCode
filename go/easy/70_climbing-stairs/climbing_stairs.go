// Package climbingstairs contains solution for LeetCode problem: #70. Climbing Stairs.
package climbingstairs

// climbStairs returns number of distinct ways stairs can be climbed.
func climbStairs(n int) int {
	next, nextNext := 0, 1
	for i := n; i > 0; i-- {
		next, nextNext = nextNext, nextNext+next
	}
	return nextNext
}
