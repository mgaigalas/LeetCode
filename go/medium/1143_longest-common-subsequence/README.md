# #1143. Longest Common Subsequence

<p>Given two strings <code>text1</code> and <code>text2</code>, return <em>the length of their longest <strong>common subsequence</strong>. </em>If there is no <strong>common subsequence</strong>, return <code>0</code>.</p>

<p>A <strong>subsequence</strong> of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.</p>

<ul>
	<li>For example, <code>"ace"</code> is a subsequence of <code>"abcde"</code>.</li>
</ul>

<p>A <strong>common subsequence</strong> of two strings is a subsequence that is common to both strings.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> text1 = "abcde", text2 = "ace" 
<strong>Output:</strong> 3  
<strong>Explanation:</strong> The longest common subsequence is "ace" and its length is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> text1 = "abc", text2 = "abc"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The longest common subsequence is "abc" and its length is 3.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> text1 = "abc", text2 = "def"
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no such common subsequence, so the result is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= text1.length, text2.length &lt;= 1000</code></li>
	<li><code>text1</code> and <code>text2</code> consist of only lowercase English characters.</li>
</ul>

## Notes 

Dynamic Programming - Top-Down approach (with memoization)

```go
// Package longestcommonsubsequence contains solution for LeetCode problem: #1143. Longest Common Subsequence.
package longestcommonsubsequence

// longestCommonSubsequence given two strings text1 and text2, returns the length of their longest common subsequence.
// If there is no common subsequence, returns 0.
func longestCommonSubsequence(text1 string, text2 string) int {
	m := len(text1)
	n := len(text2)
	memo := make([][]int, m)
	for i := 0; i < m; i++ {
		arr := make([]int, n)
		for j := 0; j < n; j++ {
			arr[j] = -1
		}
		memo[i] = arr
	}
	var dp func(i, j int) int
	dp = func(i, j int) int {
		if i == len(text1) || j == len(text2) {
			return 0
		}

		if memo[i][j] != -1 {
			return memo[i][j]
		}

		var res int
		if text1[i] == text2[j] {
			res = 1 + dp(i+1, j+1)
		} else {
			res = max(dp(i+1, j), dp(i, j+1))
		}
		memo[i][j] = res
		return res
	}
	res := dp(0, 0)
	return res
}
```