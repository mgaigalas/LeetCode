# 967. Numbers With Same Consecutive Differences

<p>Given two integers n and k, return <em>an array of all the integers of length </em><code>n</code><em> where the difference between every two consecutive digits is </em><code>k</code>. You may return the answer in <strong>any order</strong>.</p>

<p>Note that the integers should not have leading zeros. Integers as <code>02</code> and <code>043</code> are not allowed.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 3, k = 7
<strong>Output:</strong> [181,292,707,818,929]
<strong>Explanation:</strong> Note that 070 is not a valid number, because it has leading zeroes.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 2, k = 1
<strong>Output:</strong> [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 9</code></li>
	<li><code>0 &lt;= k &lt;= 9</code></li>
</ul>

## Notes

Standard way to solve this without any optimizations via backtracking

```go
// Package numswithsameconsecdiffs contains solution for LeetCode problem:
// #967. Numbers With Same Consecutive Differences.
package numswithsameconsecdiffs

// numsSameConsecDiff given two integers n and k, returns an array of all the integers of length n where the difference
// between every two consecutive digits is k.
func numsSameConsecDiff(n int, k int) []int {
	res := make([]int, 0)
	paths := make([]int, 0)
	var backtrack func(start int)
	backtrack = func(start int) {
		if len(paths) > 1 && abs(paths[len(paths)-1]-paths[len(paths)-2]) != k {
			return
		}

		if len(paths) == n {
			var num int
			for i := 0; i < len(paths); i++ {
				if num == 0 {
					num = paths[i]
					continue
				}
				num *= 10
				num += paths[i]
			}
			res = append(res, num)
			return
		}

		for i := 0; i < 10; i++ {
			if len(paths) == 0 && i == 0 {
				continue
			}
			paths = append(paths, i)
			backtrack(i)
			paths = paths[:len(paths)-1]
		}
	}
	backtrack(1)
	return res
}

func abs(source int) int {
	if source < 0 {
		return -source
	}
	return source
}
```