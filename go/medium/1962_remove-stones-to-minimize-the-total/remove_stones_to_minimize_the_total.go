// Package removestonestominimizetotal contains solution for LeetCode problem:
// #1962. Remove Stones to Minimize the Total.
package removestonestominimizetotal

import (
	"container/heap"
	"math"
)

// Heap is a data structure representing Heap.
type Heap []int

// Len is the number of elements in the collection. This is implementation of sort interface.
func (h *Heap) Len() int {
	return len(*h)
}

// Less returns if ith element is less than jth element. This is implementation of sort interface.
func (h *Heap) Less(i, j int) bool {
	return (*h)[i] > (*h)[j]
}

// Swap swaps the elements with indexes i and j. This is implementation of sort interface.
func (h *Heap) Swap(i, j int) {
	(*h)[i], (*h)[j] = (*h)[j], (*h)[i]
}

// Push pushes element on a Heap. This is implementation of heap interface.
func (h *Heap) Push(x any) {
	*h = append(*h, x.(int))
}

// Pop pops element from a Heap. This is implementation of heap interface.
func (h *Heap) Pop() any {
	n := h.Len()
	x := (*h)[n-1]
	*h = (*h)[:n-1]
	return x
}

// minStoneSum returns the minimum possible total number of stones remaining after applying the k operations.
func minStoneSum(piles []int, k int) int {
	h := Heap(piles)
	heap.Init(&h)
	for i := 0; i < k; i++ {
		maxVal := heap.Pop(&h).(int)
		val := int(math.Floor(float64(maxVal) / 2.0))
		heap.Push(&h, maxVal-val)
	}

	var res int
	for _, val := range h {
		res += val
	}
	return res
}
