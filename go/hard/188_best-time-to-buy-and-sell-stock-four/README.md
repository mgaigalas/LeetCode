# #188. Best Time to Buy and Sell Stock IV

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>k</code>.</p>

<p>Find the maximum profit you can achieve. You may complete at most <code>k</code> transactions: i.e. you may buy at most <code>k</code> times and sell at most <code>k</code> times.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> k = 2, prices = [2,4,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> k = 2, prices = [3,2,6,5,0,3]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 100</code></li>
	<li><code>1 &lt;= prices.length &lt;= 1000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>

## Notes

Dynamic Programming - Top-Down approach

```go
// Package besttimetobuyandsellstockfour contains solution for LeetCode problem:
// #188. Best Time to Buy and Sell Stock IV.
package besttimetobuyandsellstockfour

// maxProfit finds maximum profit that can achieved.
func maxProfit(k int, prices []int) int {
	n := len(prices)
	m := 2
	memo := make([][][]int, n+1)
	for i := 0; i < n; i++ {
		holMem := make([][]int, m)
		for j := 0; j < m; j++ {
			remMem := make([]int, k+1)
			for l := 0; l <= k; l++ {
				remMem[l] = -1
			}
			holMem[j] = remMem
		}
		memo[i] = holMem
	}

	var dp func(i, holding, remain int) int
	dp = func(i, holding, remain int) int {
		if i == n || remain == 0 {
			return 0
		}

		if val := memo[i][holding][remain]; val != -1 {
			return val
		}

		res := dp(i+1, holding, remain)
		if holding == 1 {
			res = max(res, prices[i] + dp(i+1, 0, remain-1))
		} else {
			res = max(res, -prices[i] + dp(i+1, 1, remain))
		}
		memo[i][holding][remain] = res
		return res
	}
	return dp(0, 0, k)
}
```