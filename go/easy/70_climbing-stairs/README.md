# #70. Climbing Stairs

<p>You are climbing a staircase. It takes <code>n</code> steps to reach the top.</p>

<p>Each time you can either climb <code>1</code> or <code>2</code> steps. In how many distinct ways can you climb to the top?</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 45</code></li>
</ul>

## Notes

Dynamic Programming - Top-Down approach with memoization

```go
// Package climbingstairs contains solution for LeetCode problem: #70. Climbing Stairs.
package climbingstairs

// climbStairs returns number of distinct ways stairs can be climbed.
func climbStairs(n int) int {
	mem := make(map[int]int)
	var dp func(i int) int
	dp = func(i int) int {
		if val, exists := mem[i]; exists {
			return val
		}

		if i == 0 {
			return 0
		}

		if i == 1 {
			return 1
		}

		nextVal := dp(i-1) + dp(i-2)
		mem[i] = nextVal
		return nextVal
	}
	return dp(n + 1)
}
```

Dynamic Programming - Bottom-Up approach

```go
// Package climbingstairs contains solution for LeetCode problem: #70. Climbing Stairs.
package climbingstairs

// climbStairs returns number of distinct ways stairs can be climbed.
func climbStairs(n int) int {
	res := make([]int, n+2)
	res[1] = 1
	for i := 2; i <= n+1; i++ {
		res[i] = res[i-1] + res[i-2]
	}
	return res[n+1]
}
```