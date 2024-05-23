// Package insertinterval contains solution for LeetCode problem: #57. Insert Interval.
package insertinterval

// insert inserts newInterval into intervals in a way that newInterval does not overlap
// removing overlapping intervals.
func insert(intervals [][]int, newInterval []int) [][]int {
	if len(intervals) == 0 {
		return [][]int{newInterval}
	}

	// Binary Search for finding insertion point (start).
	// This can be used as intervals 2D array is already sorted by first element in each element within array).
	var bs func(intervals [][]int, target int) int
	bs = func(intervals [][]int, target int) int {
		left, right := 0, len(intervals)-1
		for left <= right {
			mid := left + (right-left)/2
			if intervals[mid][0] <= target {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
		return left
	}
	insertStart := bs(intervals, newInterval[0])

	// Once insertion point (start) has been found - we need to add ALL elements.
	// This will create situation, where new array has overlapping elements.
	// This need to be dealt separately.
	temp := make([][]int, 0)
	for i := 0; i < insertStart; i++ {
		temp = append(temp, intervals[i])
	}
	temp = append(temp, newInterval)
	for i := insertStart; i < len(intervals); i++ {
		temp = append(temp, intervals[i])
	}

	res := make([][]int, 0)
	for _, interval := range temp {
		start, end := interval[0], interval[1]
		if len(res) != 0 && start <= res[len(res)-1][1] {
			res[len(res)-1][1] = max(res[len(res)-1][1], end)
		} else {
			res = append(res, interval)
		}
	}

	return res
}
