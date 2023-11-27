// Package equalsubstrswithinbudget contains solution for LeetCode problem: #2000. Reverse Prefix of Word.
package equalsubstrswithinbudget

// equalSubstring returns the maximum length of a substring of s that can be changed to be the same as the
// corresponding substring of t with a cost less than or equal to maxCost.
// If there is no substring from s that can be changed to its corresponding substring from t, returns 0.
func equalSubstring(s string, t string, maxCost int) int {
	var left, res, sum int
	for right := 0; right < len(s); right++ {
		sum += absSum(s[right], t[right])
		for sum > maxCost {
			sum -= absSum(s[left], t[left])
			left++
		}
		res = max(res, right-left+1)
	}
	return res
}

// absSum returns absolute sum of two uint8 numbers as an int
func absSum(leftVal, rightVal uint8) int {
	sum := int(rightVal) - int(leftVal)
	if sum < 0 {
		sum *= -1
	}
	return sum
}
