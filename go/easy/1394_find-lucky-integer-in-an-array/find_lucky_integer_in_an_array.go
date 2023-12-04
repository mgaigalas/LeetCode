// Package findluckyintegerinanarray contains solution for LeetCode problem: #1394. Find Lucky Integer in an Array.
package findluckyintegerinanarray

// findLucky returns the largest lucky integer in the array. If there is no lucky integer return -1.
func findLucky(arr []int) int {
	m, res := make(map[int]int, len(arr)), -1
	for _, val := range arr {
		m[val]++
	}

	for k, v := range m {
		if k != v {
			continue
		}
		res = max(res, k)
	}

	return res
}
