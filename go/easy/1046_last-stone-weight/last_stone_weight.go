// Package laststoneweight contains solution for LeetCode problem: #1046. Last Stone Weight.
package laststoneweight

import "container/heap"

// Heap is a data structure representing Heap.
type Heap []int

// Len is the number of elements in the collection. This is implementation of sort interface.
func (h *Heap) Len() int {
	return len(*h)
}

// Less returns if ith element is less than jth element. This is implementation of sort interface.
// Since this problem requires max heap instead of min, we need to inverse comparison.
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
	curr := *h
	n := len(curr)
	x := curr[n-1]
	*h = curr[0 : n-1]
	return x
}

// lastStoneWeight returns the weight of the last remaining stone. If there are no stones left, return 0.
func lastStoneWeight(stones []int) int {
	h := Heap(stones)
	heap.Init(&h)
	for h.Len() > 1 {
		first := heap.Pop(&h).(int)
		second := heap.Pop(&h).(int)
		if first != second {
			heap.Push(&h, first-second)
		}
	}

	if h.Len() != 0 {
		return h.Pop().(int)
	}
	return 0
}
