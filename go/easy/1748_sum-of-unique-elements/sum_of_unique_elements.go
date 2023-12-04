// Package sumofuniqueelements contains solution for LeetCode problem: #1748. Sum of Unique Elements.
package sumofuniqueelements

// sumOfUnique returns the sum of all the unique elements of nums.
func sumOfUnique(nums []int) int {
	m, sum := make(map[int]int, len(nums)), 0
	for _, num := range nums {
		m[num]++
	}

	for k, v := range m {
		if v > 1 {
			continue
		}
		sum += k
	}
	return sum
}
