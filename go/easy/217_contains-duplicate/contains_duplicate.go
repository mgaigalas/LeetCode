// Package containsduplicate contains solution for LeetCode problem: #217. Contains Duplicate.
package containsduplicate

// containsDuplicate given an integer array nums, returns true if any value appears at least twice in the array,
// and return false if every element is distinct.
func containsDuplicate(nums []int) bool {
	m := make(map[int]struct{}, len(nums))
	for _, num := range nums {
		if _, ok := m[num]; ok {
			return true
		}
		m[num] = struct{}{}
	}
	return false
}
