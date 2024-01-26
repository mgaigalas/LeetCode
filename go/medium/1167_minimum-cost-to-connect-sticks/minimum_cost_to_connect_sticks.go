// Package minimumcosttoconnectsticks contains solution for LeetCode problem:
// #1167. Minimum Cost to Connect Sticks.
package minimumcosttoconnectsticks

import "container/heap"

// Heap is a data structure representing Heap.
type Heap []int

// Len is the number of elements in the collection. This is implementation of sort interface.
func (h *Heap) Len() int {
	return len(*h)
}

// Less returns if ith element is less than jth element. This is implementation of sort interface.
func (h *Heap) Less(i, j int) bool {
	return (*h)[i] < (*h)[j]
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

// connectSticks returns the minimum cost of connecting all the given sticks into one stick in this way.
func connectSticks(sticks []int) int {
	h := Heap(sticks)
	heap.Init(&h)
	var sum, res int
	for h.Len() > 1 {
		sum = heap.Pop(&h).(int) + heap.Pop(&h).(int)
		res += sum
		heap.Push(&h, sum)
	}
	return res
}
