// Package maxnumofballoons contains solution for LeetCode problem: #1189. Maximum Number of Balloons.
package maxnumofballoons

// maxNumberOfBalloons given a string text, using the characters of text forms as many instances of the word "balloon"
// as possible.
func maxNumberOfBalloons(text string) int {
	m := make(map[uint8]int, len(text))
	for i := 0; i < len(text); i++ {
		m[text[i]]++
	}

	var res int
	template := "balloon"
	for {
		for i := 0; i < len(template); i++ {
			m[template[i]]--
			if m[template[i]] < 0 {
				return res
			}
		}
		res++
	}
}
