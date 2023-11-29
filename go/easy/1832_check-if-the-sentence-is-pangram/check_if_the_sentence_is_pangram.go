// Package findpivotindex contains solution for LeetCode problem: #1832. Check if the Sentence Is Pangram.
package sentenceispangram

// checkIfPangram returns true if sentence is pangram (contains all alphabetic letters)
func checkIfPangram(sentence string) bool {
	d := make(map[rune]struct{})
	for _, val := range sentence {
		d[val] = struct{}{}
		if len(d) == 26 {
			return true
		}
	}
	return false
}
