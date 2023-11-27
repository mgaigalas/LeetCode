// Package rangesumqueryimtbl contains solution for LeetCode problem: #2000. Reverse Prefix of Word.
package reverseprefixofword

// reversePrefix given a 0-indexed string word and a character ch, reverses the segment of word that starts at index 0
// and ends at the index of the first occurrence of ch (inclusive).
// If the character ch does not exist in word, does nothing.
func reversePrefix(word string, ch byte) string {
	bytes := []byte(word)
	for i := 0; i < len(word); i++ {
		if word[i] == ch {
			left, right := 0, i
			for left < right {
				bytes[left], bytes[right] = bytes[right], bytes[left]
				left++
				right--
			}
			break
		}
	}
	return string(bytes)
}
