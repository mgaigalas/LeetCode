// Package kclosestpointstoorigin contains solution for LeetCode problem: #973. K Closest Points to Origin.
package kclosestpointstoorigin

import "container/heap"

// Heap is a data structure representing Heap.
type Heap [][]int

// Len is the number of elements in the collection. This is implementation of sort interface.
func (h *Heap) Len() int {
	return len(*h)
}

// Less returns if ith element is less than jth element. This is implementation of sort interface.
func (h *Heap) Less(i, j int) bool {
	if originDistanceSquared((*h)[i]) > originDistanceSquared((*h)[j]) {
		return true
	}
	return false
}

// Swap swaps the elements with indexes i and j. This is implementation of sort interface.
func (h *Heap) Swap(i, j int) {
	(*h)[i], (*h)[j] = (*h)[j], (*h)[i]
}

// Push pushes element on a Heap. This is implementation of heap interface.
func (h *Heap) Push(x any) {
	*h = append(*h, x.([]int))
}

// Pop pops element from a Heap. This is implementation of heap interface.
func (h *Heap) Pop() any {
	n := h.Len()
	x := (*h)[n-1]
	*h = (*h)[:n-1]
	return x
}

// originDistanceSquared returns distance sqaured from point of origin (0,0).
func originDistanceSquared(point []int) int {
	return point[0]*point[0] + point[1]*point[1]
}

// kClosest returns the k closest points to the origin (0, 0).
func kClosest(points [][]int, k int) [][]int {
	h := Heap(points)
	heap.Init(&h)
	for h.Len() > k {
		heap.Pop(&h)
	}
	return h
}
