// Package countingelements contains solution for LeetCode problem: #1426. Counting Elements.
package countingelements

// countElements given an integer array arr, counts how many elements x there are, such that x + 1 is also in arr.
// If there are duplicates in arr, counts them separately.
func countElements(arr []int) int {
	var count int
	m := make(map[int]struct{}, len(arr))
	for _, val := range arr {
		m[val] = struct{}{}
	}

	for _, val := range arr {
		if _, ok := m[val+1]; ok {
			count++
		}
	}
	return count
}
