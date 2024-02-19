# #322. Coin Change

<p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>

<p>Return <em>the fewest number of coins that you need to make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>-1</code>.</p>

<p>You may assume that you have an infinite number of each kind of coin.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> coins = [1,2,5], amount = 11
<strong>Output:</strong> 3
<strong>Explanation:</strong> 11 = 5 + 5 + 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> coins = [2], amount = 3
<strong>Output:</strong> -1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> coins = [1], amount = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 12</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
</ul>

## Notes

Dynamic Programming - Top-Down approach

```go
// Package coinchange contains solution for LeetCode problem: #322. Coin Change.
package coinchange

import "math"

// coinChange returns the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, returns -1.
func coinChange(coins []int, amount int) int {
	if amount < 1 {
		return 0
	}

	counts := make([]int, amount)
	var dp func(remainder int) int
	dp = func(remainder int) int {
		if remainder == 0 {
			return 0
		}
		if remainder < 0 {
			return -1
		}

		if counts[remainder-1] != 0 {
			return counts[remainder-1]
		}

		minAmount := math.MaxInt64
		for _, coin := range coins {
			res := dp(remainder - coin)
			if res >= 0 && res < minAmount {
				minAmount = 1 + res
			}
		}

		if minAmount == math.MaxInt64 {
			counts[remainder-1] = -1
		} else {
			counts[remainder-1] = minAmount
		}
		return counts[remainder-1]
	}
	return dp(amount)
}
```

Dynamic Programming - Bottom-Up approach. This approach cna have integer overflow as it can have case of 
`1 + math.MaxInt64`, therefore it has to be handled as a special case. At a same time, problem has a constraint of 
`1 <= coins[i] <= 2^31 - 1`, which restricts max coin being as 32-bit integer. Therefore we can use `1 + math.MaxInt32` 
as a workaround. This would overflow to 64-bit range, however this is OK as in GO `int` is <i>at least</i> 32-bit 
integer, which means it can be overflown to 64-bit without losing actual value

```go
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
		dp[i] = math.MaxInt64
	}

	for _, c := range coins {
		for r := c; r <= amount; r++ {
			nextVal := dp[r-c]
			if nextVal != math.MaxInt64 {
				nextVal += 1
			}
			dp[r] = min(dp[r], nextVal)
		}
	}

	if dp[amount] == math.MaxInt64 {
		return -1
	}
	return dp[amount]
}
```