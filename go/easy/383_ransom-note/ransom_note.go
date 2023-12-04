// Package ransomnote contains solution for LeetCode problem: #383. Ransom Note.
package ransomnote

// canConstruct given two strings ransomNote and magazine, returns true if ransomNote can be constructed by using
// the letters from magazine and false otherwise.
func canConstruct(ransomNote string, magazine string) bool {
	m := make([]int, 26)
	for _, c := range magazine {
		m[c-'a']++
	}

	for _, c := range ransomNote {
		m[c-'a']--
		if m[c-'a'] < 0 {
			return false
		}
	}
	return true
}
