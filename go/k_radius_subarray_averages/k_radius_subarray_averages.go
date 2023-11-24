// Package kradiussubarrayavgs contains solution for LeetCode problem: #2090. K Radius Subarray Averages.
package kradiussubarrayavgs

// getAverages returns an array avgs of length n where avgs[i] is the k-radius average for the subarray
// centered at index i
func getAverages(nums []int, k int) []int {
	curr, n := 0, len(nums)
	prefixSum := make([]int, n)
	for i := 0; i < n; i++ {
		curr += nums[i]
		prefixSum[i] = curr
	}

	res := make([]int, n)
	left, right := 0-k, k
	for i := 0; i < n; i++ {
		if left >= 0 && right < n {
			res[i] = (prefixSum[right] - prefixSum[left] + nums[left]) / (right - left + 1)
		} else {
			res[i] = -1
		}
		left++
		right++
	}
	return res
}
