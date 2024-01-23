// Package jumpgamethree contains solution for LeetCode problem: #1306. Jump Game III.
package jumpgamethree

// canReach check if any index is reachable with index value 0.
func canReach(arr []int, start int) bool {
	queue := make([]int, 1, len(arr))
	queue[0] = start
	seen := make(map[int]struct{}, len(arr))
	seen[start] = struct{}{}

	nextIndexes := make([]int, 2)
	for len(queue) > 0 {
		index := queue[0]
		queue = queue[1:]
		if arr[index] == 0 {
			return true
		}

		nextIndexes[0] = index - arr[index]
		nextIndexes[1] = index + arr[index]
		for _, nextIndex := range nextIndexes {
			if nextIndex < 0 || nextIndex >= len(arr) {
				continue
			}

			if _, exist := seen[nextIndex]; !exist {
				seen[nextIndex] = struct{}{}
				queue = append(queue, nextIndex)
			}
		}
	}
	return false
}
