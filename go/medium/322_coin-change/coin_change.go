// Package coinchange contains solution for LeetCode problem: #322. Coin Change.
package coinchange

import "math"

// coinChange returns the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, returns -1.
func coinChange(coins []int, amount int) int {
	if amount < 1 {
		return 0
	}

	dp := make([]int, amount+1)
	dp[0] = 0
	for i := 1; i < len(dp); i++ {
		dp[i] = math.MaxInt32
	}

	for _, c := range coins {
		for r := c; r <= amount; r++ {
			// second argument can overflow to 64-bit integer
			// this is OK as Go int type is AT LEAST 32-bit integer
			dp[r] = min(dp[r], 1+dp[r-c])
		}
	}

	if dp[amount] == math.MaxInt32 {
		return -1
	}
	return dp[amount]
}
