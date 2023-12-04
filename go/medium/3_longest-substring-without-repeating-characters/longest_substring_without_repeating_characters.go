// Package longestsubstrworepeatingchars contains solution for LeetCode problem: #3. Longest Substring Without
// Repeating Characters.
package longestsubstrworepeatingchars

// lengthOfLongestSubstring given a string s, finds the length of the longest substring without repeating characters.
func lengthOfLongestSubstring(s string) int {
	cmp := make(map[uint8]int, len(s))
	var res, left int
	for right := 0; right < len(s); right++ {
		if val, ok := cmp[s[right]]; ok {
			left = max(left, val)
		}
		res = max(res, right-left+1)
		cmp[s[right]] = right + 1
	}
	return res
}
