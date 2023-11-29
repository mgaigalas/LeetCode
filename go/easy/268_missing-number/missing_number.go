// Package missingnumber contains solution for LeetCode problem: #268. Missing Number.
package missingnumber

// missingNumber given an array nums containing n distinct numbers in the range [0, n], returns the only number in the
// range that is missing from the array.
// Note: This solution uses Gauss's Sum of the First n Positive Integers formula.
func missingNumber(nums []int) int {
	var sum int
	for _, val := range nums {
		sum += val
	}
	return (len(nums) * (len(nums) + 1) / 2) - sum
}
