// Package uniquenumberofoccurrences contains solution for LeetCode problem: #1207. Unique Number of Occurrences.
package uniquenumberofoccurrences

// uniqueOccurrences given an array of integers arr, returns true if the number of occurrences of each value in
// the array is unique or false otherwise.
func uniqueOccurrences(arr []int) bool {
	m := make(map[int]int, len(arr))
	for _, v := range arr {
		m[v]++
	}

	n := make(map[int]struct{}, len(m))
	for _, v := range m {
		if _, ok := n[v]; ok {
			return false
		}
		n[v] = struct{}{}
	}
	return true
}
