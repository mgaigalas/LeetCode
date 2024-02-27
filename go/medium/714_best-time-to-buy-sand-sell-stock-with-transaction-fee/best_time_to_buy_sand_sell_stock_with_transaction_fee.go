// Package besttimetobuysandsellstockwithtrfee contains solution for LeetCode problem:
// #714. Best Time to Buy and Sell Stock with Transaction Fee.
package besttimetobuysandsellstockwithtrfee

// maxProfit finds maximum profit that can achieved.
// this is Dynamic-Programming with optimized space.
func maxProfit(prices []int, fee int) int {
	hold := -prices[0]
	free := 0
	for i := 1; i < len(prices); i++ {
		tmp := hold
		hold = max(hold, free-prices[i])
		free = max(free, tmp+prices[i]-fee)
	}
	return free
}
