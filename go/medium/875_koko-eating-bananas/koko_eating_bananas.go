// Package kokoeatingbananas contains solution for LeetCode problem: #875. Koko Eating Bananas.
package kokoeatingbananas

import "math"

// minEatingSpeed returns the minimum integer k such that she can eat all the bananas within h hours.
func minEatingSpeed(piles []int, h int) int {
	limit := float64(h)
	minSpeed, maxSpeed := 1, 0
	for _, val := range piles {
		maxSpeed = max(maxSpeed, val)
	}

	for minSpeed <= maxSpeed {
		midSpeed := minSpeed + (maxSpeed-minSpeed)/2
		if isValidSpeed(midSpeed, piles, limit) {
			maxSpeed = midSpeed - 1
		} else {
			minSpeed = midSpeed + 1
		}
	}
	return minSpeed
}

func isValidSpeed(speed int, piles []int, limit float64) bool {
	var hours float64
	for _, bananas := range piles {
		hours += math.Ceil(float64(bananas) / float64(speed))
	}
	if hours <= limit {
		return true
	}
	return false
}
