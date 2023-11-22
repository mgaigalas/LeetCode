// Package maxsubarrayone contains solution for LeetCode problem: #643. Maximum Average Subarray Iy.
package maxsubarrayone

// findMaxAverage returns contiguous subarray whose length is equal to k that has the maximum average value.
func findMaxAverage(nums []int, k int) float64 {
	var curr int
	for i := 0; i < k; i++ {
		curr += nums[i]
	}

	res := curr
	for i := k; i < len(nums); i++ {
		if curr += nums[i] - nums[i-k]; curr > res {
			res = curr
		}
	}
	return float64(res) / float64(k)
}
