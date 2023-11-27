// Package rangesumqueryimtbl contains solution for LeetCode problem: #303. Range Sum Query - Immutable.
package rangesumqueryimtbl

// NumArray type is an iternal representation of pre-processed integer numbers.
type NumArray struct {
	nums []int
}

// Constructor pre-processes nums and returns them as NumArray wrapper.
func Constructor(nums []int) NumArray {
	pfxNums := make([]int, len(nums))
	pfxNums[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		pfxNums[i] = pfxNums[i-1] + nums[i]
	}
	return NumArray{
		nums: pfxNums,
	}
}

// SumRange returns sum within provided range (left/right brackets).
func (this *NumArray) SumRange(left int, right int) int {
	if left == 0 {
		return this.nums[right]
	}
	return this.nums[right] - this.nums[left-1]
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */
