// Package dividechocolate contains solution for LeetCode problem: #1231. Divide Chocolate.
package dividechocolate

import "math"

// maximizeSweetness finds the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
func maximizeSweetness(sweetness []int, k int) int {
	sum, peopleCount := 0, k+1
	left := math.MaxInt64
	for _, val := range sweetness {
		sum += val
		left = min(left, val)
	}

	right := int(float64(sum) / float64(k+1))
	for left <= right {
		mid := left + (right-left)/2
		if isValid(mid, peopleCount, sweetness) {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return right
}

func isValid(sweetnessIdx int, peopleCount int, sweetness []int) bool {
	var currSweetnessIdx, partCount int
	for _, val := range sweetness {
		currSweetnessIdx += val
		if currSweetnessIdx >= sweetnessIdx {
			partCount++
			currSweetnessIdx = 0
		}
	}
	return partCount >= peopleCount
}
