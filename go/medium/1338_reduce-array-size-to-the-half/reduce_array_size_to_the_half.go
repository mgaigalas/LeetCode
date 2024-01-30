// Package reducearraysizetohalf contains solution for LeetCode problem: #1338. Reduce Array Size to The Half.
package reducearraysizetohalf

import "sort"

// minSetSize returns the minimum size of the set so that at least half of the integers of the array are removed.
func minSetSize(arr []int) int {
	freqMap := make(map[int]int)
	for i := 0; i < len(arr); i++ {
		freqMap[arr[i]]++
	}

	freqSlice := make([]int, 0, len(freqMap))
	for _, val := range freqMap {
		freqSlice = append(freqSlice, val)
	}
	sort.Slice(freqSlice, func(i, j int) bool {
		return freqSlice[i] > freqSlice[j]
	})

	var removedCount, res int
	for i := 0; i < len(freqSlice); i++ {
		removedCount += freqSlice[i]
		res++
		if removedCount >= len(arr)/2 {
			return res
		}
	}
	return 0
}
