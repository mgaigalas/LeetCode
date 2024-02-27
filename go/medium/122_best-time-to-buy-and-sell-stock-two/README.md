# #122. Best Time to Buy and Sell Stock II

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>On each day, you may decide to buy and/or sell the stock. You can only hold <strong>at most one</strong> share of the stock at any time. However, you can buy it then immediately sell it on the <strong>same day</strong>.</p>

<p>Find and return <em>the <strong>maximum</strong> profit you can achieve</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>

## Notes

Dynamic Programming - Top-Down approach

```go
// Package besttimetobuyandsellstocktwo contains solution for LeetCode problem:
// #122. Best Time to Buy and Sell Stock II.
package besttimetobuyandsellstocktwo

// maxProfit finds and returns the maximum profit that can achieved.
func maxProfit(prices []int) int {
	var dp func(i, holding int) int
	dp = func(i, holding int) int {
		if i == len(prices) {
			return 0
		}

		res := dp(i+1, holding)
		if holding == 1 {
			res = max(res, prices[i]+dp(i+1, 0))
		} else {
			res = max(res, -prices[i]+dp(i+1, 1))
		}
		return res
	}
	return dp(0, 0)
}
```

Dynamic Programming - Bottom-Up approach

```go
// Package besttimetobuyandsellstocktwo contains solution for LeetCode problem:
// #122. Best Time to Buy and Sell Stock II.
package besttimetobuyandsellstocktwo

// maxProfit finds and returns the maximum profit that can achieved.
func maxProfit(prices []int) int {
	n := len(prices)
	m := 2
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, m)
	}

	for i := n - 1; i >= 0; i-- {
		for holding := 0; holding < m; holding++ {
			res := dp[i+1][holding]
			if holding == 1 {
				res = max(res, prices[i]+dp[i+1][0])
			} else {
				res = max(res, -prices[i]+dp[i+1][1])
			}
			dp[i][holding] = res
		}
	}
	return dp[0][0]
}
```

Dynamic Programming - single pass

```go
// Package besttimetobuyandsellstocktwo contains solution for LeetCode problem:
// #122. Best Time to Buy and Sell Stock II.
package besttimetobuyandsellstocktwo

// maxProfit finds and returns the maximum profit that can achieved.
func maxProfit(prices []int) int {
holding := -prices[0]
free := 0

	for i := 1; i < len(prices); i++ {
		tmp := holding
		holding = max(holding, free-prices[i])
		free = max(free, tmp+prices[i])
	}
	return free
}
```