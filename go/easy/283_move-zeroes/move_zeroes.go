// Package rangesumqueryimtbl contains solution for LeetCode problem: #283. Move Zeroes.
package movezeroes

// moveZeroes moves zeros to end of array.
func moveZeroes(nums []int) {
	left, n := 0, len(nums)
	for right := 1; right < n; right++ {
		if nums[left] == 0 && nums[right] != 0 {
			nums[left], nums[right] = nums[right], nums[left]
		}

		if nums[left] != 0 {
			left++
		}
	}
}
