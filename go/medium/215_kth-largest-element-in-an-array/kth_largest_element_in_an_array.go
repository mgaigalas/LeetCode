// Package kthlargestelementinarray contains solution for LeetCode problem: #215. Kth Largest Element in an Array.
package kthlargestelementinarray

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

// findKthLargest given an integer array nums and an integer k, returns the kth largest element in the array.
func findKthLargest(nums []int, k int) int {
	h := Heap(nums)
	heap.Init(&h)
	for h.Len() > k {
		heap.Pop(&h)
	}
	return heap.Pop(&h).(int)
}
