// Package reverseonlyletters contains solution for LeetCode problem: #917. Reverse Only Letters.
package reverseonlyletters

// reverseOnlyLetters return s after reversing it.
func reverseOnlyLetters(s string) string {
	left, right := 0, len(s)-1
	res := []rune(s)
	for left < right {
		if !isValidLetter(res[left]) {
			left++
			continue
		}

		if !isValidLetter(res[right]) {
			right--
			continue
		}

		res[left], res[right] = res[right], res[left]
		left++
		right--
	}
	return string(res)
}

// isValidLetter checks if rune is a valid alphabetic letter.
// note: same effect can be achieved with unicode.isLetter().
func isValidLetter(char rune) bool {
	if (char >= 65 && char <= 90) || (char >= 97 && char <= 122) {
		return true
	}
	return false
}
