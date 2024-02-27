// Package besttimetobuyandsellstockfour contains solution for LeetCode problem:
// #188. Best Time to Buy and Sell Stock IV.
package besttimetobuyandsellstockfour

// maxProfit finds maximum profit that can achieved.
func maxProfit(k int, prices []int) int {
	n := len(prices)
	m := 2
	dp := make([][][]int, n+1)
	for i := 0; i <= n; i++ {
		holdMem := make([][]int, m)
		for j := 0; j < m; j++ {
			holdMem[j] = make([]int, k+1)
		}
		dp[i] = holdMem
	}

	for i := n - 1; i >= 0; i-- {
		for remain := 1; remain <= k; remain++ {
			for holding := 0; holding < 2; holding++ {
				res := dp[i+1][holding][remain]
				if holding == 1 {
					res = max(res, prices[i]+dp[i+1][0][remain-1])
				} else {
					res = max(res, -prices[i]+dp[i+1][1][remain])
				}
				dp[i][holding][remain] = res
			}
		}
	}
	return dp[0][0][k]
}
