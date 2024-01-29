// Package maximumsixtyninenumber contains solution for LeetCode problem: #1323. Maximum 69 Number.
package maximumsixtyninenumber

import (
	"strconv"
)

// maximum69Number returns the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
func maximum69Number(num int) int {
	numChars := []rune(strconv.Itoa(num))
	for i, val := range numChars {
		if val == '6' {
			numChars[i] = '9'
			break
		}
	}

	res, err := strconv.Atoi(string(numChars))
	if err != nil {
		panic(err)
	}
	return res
}
