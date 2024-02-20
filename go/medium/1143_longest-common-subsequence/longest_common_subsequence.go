// Package longestcommonsubsequence contains solution for LeetCode problem: #1143. Longest Common Subsequence.
package longestcommonsubsequence

// longestCommonSubsequence given two strings text1 and text2, returns the length of their longest common subsequence.
// If there is no common subsequence, returns 0.
func longestCommonSubsequence(text1 string, text2 string) int {
	m := len(text1)
	n := len(text2)
	dp := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
	}
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			if text1[i] == text2[j] {
				dp[i][j] = 1 + dp[i+1][j+1]
			} else {
				dp[i][j] = max(dp[i+1][j], dp[i][j+1])
			}
		}
	}
	return dp[0][0]
}
