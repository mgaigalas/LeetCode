// Package nextgreaterelementone contains solution for LeetCode problem: #496. Next Greater Element I.
package nextgreaterelementone

// nextGreaterElement returns an array ans of length nums1.length such that ans[i] is the next greater element as
// described above.
func nextGreaterElement(nums1 []int, nums2 []int) []int {
	ngeMap := make(map[int]int, len(nums2))
	stack := make([]int, 0, len(nums2))
	var curr int
	for i := 0; i < len(nums2); i++ {
		curr = nums2[i]
		for len(stack) > 0 && curr > stack[len(stack)-1] {
			ngeMap[stack[len(stack)-1]] = curr
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, curr)
	}

	for len(stack) > 0 {
		ngeMap[stack[len(stack)-1]] = -1
		stack = stack[:len(stack)-1]
	}

	res := make([]int, len(nums1))
	for i := 0; i < len(nums1); i++ {
		res[i] = ngeMap[nums1[i]]
	}

	return res
}
