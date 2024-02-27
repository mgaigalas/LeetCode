# #714. Best Time to Buy and Sell Stock with Transaction Fee

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>fee</code> representing a transaction fee.</p>

<p>Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.</p>

<p><strong>Note:</strong></p>

<ul>
	<li>You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</li>
	<li>The transaction fee is only charged once for each stock purchase and sale.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [1,3,2,8,4,9], fee = 2
<strong>Output:</strong> 8
<strong>Explanation:</strong> The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [1,3,7,5,10,3], fee = 3
<strong>Output:</strong> 6
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= prices[i] &lt; 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= fee &lt; 5 * 10<sup>4</sup></code></li>
</ul>

## Notes

Dynamic Programming - Top-Down approach

```go
// Package besttimetobuysandsellstockwithtrfee contains solution for LeetCode problem:
// #714. Best Time to Buy and Sell Stock with Transaction Fee.
package besttimetobuysandsellstockwithtrfee

// maxProfit finds maximum profit that can achieved.
func maxProfit(prices []int, fee int) int {
	memo := make([][]int, len(prices))
	for i := 0; i < len(prices); i++ {
		m := make([]int, 2)
		for j := 0; j < len(m); j++ {
			m[j] = -1
		}
		memo[i] = m
	}

	var dp func(i, boughtState int) int
	dp = func(i, boughtState int) int {
		if i == len(prices) {
			return 0
		}

		if memo[i][boughtState] != -1 {
			return memo[i][boughtState]
		}

		res := dp(i+1, boughtState)
		if boughtState == 1 {
			res = max(res, prices[i]+dp(i+1, 0)-fee)
		} else {
			res = max(res, -prices[i]+dp(i+1, 1))
		}
		memo[i][boughtState] = res
		return res
	}
	return dp(0, 0)
}
```

Dynamic Programming - Bottom-Up approach (unoptimized)

```go
// Package besttimetobuysandsellstockwithtrfee contains solution for LeetCode problem:
// #714. Best Time to Buy and Sell Stock with Transaction Fee.
package besttimetobuysandsellstockwithtrfee

// maxProfit finds maximum profit that can achieved.
func maxProfit(prices []int, fee int) int {
	n := len(prices)
	m := 2 // "holding/bought" is a bool, which can hold states 0 || 1
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, m)
	}

	for i := n - 1; i >= 0; i-- {
		for j := 0; j < m; j++ { // reflects "holding/bought" state
			res := dp[i+1][j]
			if j == 1 {
				res = max(res, prices[i]+dp[i+1][0]-fee)
			} else {
				res = max(res, -prices[i]+dp[i+1][1])
			}
			dp[i][j] = res
		}
	}
	return dp[0][0]
}
```