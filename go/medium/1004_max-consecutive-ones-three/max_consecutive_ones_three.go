// Package maxconseconesthree contains solution for LeetCode problem: #1004. Max Consecutive Ones III.
package maxconseconesthree

// longestOnes given a binary array nums and an integer k, returns the maximum number of consecutive 1's in the array
// with at most k 0's that can be flipped.
func longestOnes(nums []int, k int) int {
	var left, curr, res int
	for right := 0; right < len(nums); right++ {
		if nums[right] == 0 {
			curr++
		}

		for curr > k {
			if nums[left] == 0 {
				curr--
			}
			left++
		}
		res = max(res, right-left+1)
	}
	return res
}
