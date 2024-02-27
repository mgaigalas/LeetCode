// Package besttimetobuyandsellstockwithcooldown contains solution for LeetCode problem:
// #309. Best Time to Buy and Sell Stock with Cooldown.
package besttimetobuyandsellstockwithcooldown

import "math"

// maxProfit finds maximum profit that can achieved.
func maxProfit(prices []int) int {
	held := math.MinInt64
	sold := math.MinInt64
	reset := 0
	for i := 0; i < len(prices); i++ {
		preSold := sold
		sold = held + prices[i]
		held = max(held, reset-prices[i])
		reset = max(reset, preSold)
	}
	return max(sold, reset)
}
