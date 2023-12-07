// Package permutationinstring contains solution for LeetCode problem: #567. Permutation in String.
package permutationinstring

// checkInclusion returns true if one of s1's permutations is the substring of s2.
func checkInclusion(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}

	s1slice, s2slice := make([]int, 26), make([]int, 26)
	for i := 0; i < len(s1); i++ {
		s1slice[s1[i]-'a']++
		s2slice[s2[i]-'a']++
	}

	for i := 0; i < len(s2)-len(s1); i++ {
		if equals(s1slice, s2slice) {
			return true
		}
		s2slice[s2[i+len(s1)]-'a']++
		s2slice[s2[i]-'a']--
	}
	return equals(s1slice, s2slice)
}

func equals(sourceSlice, targetSlice []int) bool {
	for i, v := range sourceSlice {
		if targetSlice[i] != v {
			return false
		}
	}
	return true
}
