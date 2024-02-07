// Package lettercombinationsofphonenumber contains solution for LeetCode problem:
// #17. Letter Combinations of a Phone Number.
package lettercombinationsofphonenumber

// letterCombinations given a string containing digits from 2-9 inclusive, returns all possible letter combinations
// that the number could represent.
func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}

	dict := map[byte][]byte{
		'2': {'a', 'b', 'c'},
		'3': {'d', 'e', 'f'},
		'4': {'g', 'h', 'i'},
		'5': {'j', 'k', 'l'},
		'6': {'m', 'n', 'o'},
		'7': {'p', 'q', 'r', 's'},
		'8': {'t', 'u', 'v'},
		'9': {'w', 'x', 'y', 'z'},
	}
	res := make([]string, 0)
	curr := make([]byte, 0)
	var backtrack func(i int)
	backtrack = func(i int) {
		if len(digits) == i {
			res = append(res, string(curr))
			return
		}

		for _, b := range dict[digits[i]] {
			curr = append(curr, b)
			backtrack(i + 1)
			curr = curr[:len(curr)-1]
		}
	}
	backtrack(0)
	return res
}
