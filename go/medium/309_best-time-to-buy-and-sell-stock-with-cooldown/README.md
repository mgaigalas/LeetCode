# #309. Best Time to Buy and Sell Stock with Cooldown

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:</p>

<ul>
	<li>After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).</li>
</ul>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [1,2,3,0,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> transactions = [buy, sell, cooldown, buy, sell]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 5000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>








## Notes

Dynamic Programming - Top-Down approach (with memoization)

```go
// Package besttimetobuyandsellstockwithcooldown contains solution for LeetCode problem:
// #309. Best Time to Buy and Sell Stock with Cooldown.
package besttimetobuyandsellstockwithcooldown

// maxProfit finds maximum profit that can achieved.
func maxProfit(prices []int) int {
	n := len(prices)
	m := 2
	memo := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		mem := make([]int, m)
		for j := 0; j < m; j++ {
			mem[j] = -1
		}
		memo[i] = mem
	}

	var dp func(i, holding int) int
	dp = func(i, holding int) int {
		if i >= len(prices) {
			return 0
		}

		if val := memo[i][holding]; val != -1 {
			return val
		}

		res := dp(i+1, holding)
		if holding == 1 {
			res = max(res, prices[i]+dp(i+2, 0))
		} else {
			res = max(res, -prices[i]+dp(i+1, 1))
		}
		memo[i][holding] = res
		return res
	}
	return dp(0, 0)
}
```

Dynamic Programming - Bottom-Up approach

```go
// Package besttimetobuyandsellstockwithcooldown contains solution for LeetCode problem:
// #309. Best Time to Buy and Sell Stock with Cooldown.
package besttimetobuyandsellstockwithcooldown

// maxProfit finds maximum profit that can achieved.
func maxProfit(prices []int) int {
	n := len(prices)
	m := 2
	dp := make([][]int, n+2)
	for i := 0; i < n+2; i++ {
		dp[i] = make([]int, m)
	}

	for i := n - 1; i >= 0; i-- {
		for j := 0; j < m; j++ {
			res := dp[i+1][j]
			if j == 1 {
				res = max(res, prices[i]+dp[i+2][0])
			} else {
				res = max(res, -prices[i]+dp[i+1][1])
			}
			dp[i][j] = res
		}
	}
	return dp[0][0]
}
```

Dynamic Programming - with State Machine
![State Machine](ex1.png)

```go
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
```