// Package findhighestalt contains solution for LeetCode problem: #1732. Find the Highest Altitude.
package findhighestalt

// largestAltitude given an integer array gain of length n where gain[i] is the net gain in altitude between
// points i and i + 1 for all (0 <= i < n) - returns the highest altitude of a point.
func largestAltitude(gain []int) int {
	var sum, res int
	for i := range gain {
		sum += gain[i]
		res = max(res, sum)
	}
	return res
}
