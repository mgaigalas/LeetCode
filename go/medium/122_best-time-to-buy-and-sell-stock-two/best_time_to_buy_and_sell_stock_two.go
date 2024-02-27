// Package besttimetobuyandsellstocktwo contains solution for LeetCode problem:
// #122. Best Time to Buy and Sell Stock II.
package besttimetobuyandsellstocktwo

// maxProfit finds and returns the maximum profit that can achieved.
func maxProfit(prices []int) int {
	var res int
	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i-1] {
			res += prices[i] - prices[i-1]
		}
	}
	return res
}
