// Package howmanyapplescanyouputintobasket contains solution for LeetCode problem:
// #1196. How Many Apples Can You Put into the Basket.
package howmanyapplescanyouputintobasket

import "slices"

// maxNumberOfApples returns the maximum number of apples you can put in the basket.
func maxNumberOfApples(weight []int) int {
	// apparently slices.Sort is up to 70% faster than sort.Slice
	slices.Sort(weight)

	maxWeight := 5000
	var res int
	for _, w := range weight {
		if w > maxWeight {
			break
		}
		maxWeight -= w
		res++
	}
	return res
}
