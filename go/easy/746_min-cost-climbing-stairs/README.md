# #746. Min Cost Climbing Stairs

<p>You are given an integer array <code>cost</code> where <code>cost[i]</code> is the cost of <code>i<sup>th</sup></code> step on a staircase. Once you pay the cost, you can either climb one or two steps.</p>

<p>You can either start from the step with index <code>0</code>, or the step with index <code>1</code>.</p>

<p>Return <em>the minimum cost to reach the top of the floor</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> cost = [10,<u>15</u>,20]
<strong>Output:</strong> 15
<strong>Explanation:</strong> You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> cost = [<u>1</u>,100,<u>1</u>,1,<u>1</u>,100,<u>1</u>,<u>1</u>,100,<u>1</u>]
<strong>Output:</strong> 6
<strong>Explanation:</strong> You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= cost.length &lt;= 1000</code></li>
	<li><code>0 &lt;= cost[i] &lt;= 999</code></li>
</ul>

## Notes

Dynamic Programming - Top-Down approach (with memoization)

```go
// Package mincostclimbingstairs contains solution for LeetCode problem: #746. Min Cost Climbing Stairs.
package mincostclimbingstairs

// minCostClimbingStairs returns the minimum cost to reach the top of the floor.
func minCostClimbingStairs(cost []int) int {
	mem := make(map[int]int)
	var dp func(i int) int
	dp = func(i int) int {
		if i <= 1 {
			return 0
		}

		if val, exists := mem[i]; exists {
			return val
		}
		val := min(dp(i-2)+cost[i-2], dp(i-1)+cost[i-1])
		mem[i] = val
		return val
	}
	return dp(len(cost))
}
```

Dynamic Programming - Bottom-Up approach

```go
// Package mincostclimbingstairs contains solution for LeetCode problem: #746. Min Cost Climbing Stairs.
package mincostclimbingstairs

// minCostClimbingStairs returns the minimum cost to reach the top of the floor.
func minCostClimbingStairs(cost []int) int {
	arr := make([]int, len(cost)+1)
	for i := 2; i <= len(cost); i++ {
		arr[i] = min(arr[i-2]+cost[i-2], arr[i-1]+cost[i-1])
	}
	return arr[len(cost)]
}
```

Dynamic Programming - Bottom-Up approach (with static recurrence relation optimization)

```go
// Package mincostclimbingstairs contains solution for LeetCode problem: #746. Min Cost Climbing Stairs.
package mincostclimbingstairs

// minCostClimbingStairs returns the minimum cost to reach the top of the floor.
func minCostClimbingStairs(cost []int) int {
    var prevOne, prevTwo int
    for i := 2; i <= len(cost); i++ {
        tmp := prevOne
        prevOne = min(prevOne+cost[i-1], prevTwo+cost[i-2])
        prevTwo = tmp
    }
    return prevOne
}
```