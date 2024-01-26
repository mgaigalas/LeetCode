// Package kthlargestelementinstream contains solution for LeetCode problem: #703. Kth Largest Element in a Stream.
package kthlargestelementinstream

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
	old := *h
	length := h.Len()
	x := old[length-1]
	*h = old[:length-1]
	return x
}

type KthLargest struct {
	h *Heap
	k int
}

func Constructor(k int, nums []int) KthLargest {
	h := Heap(nums)
	heap.Init(&h)
	for h.Len() > k {
		heap.Pop(&h)
	}
	return KthLargest{
		h: &h,
		k: k,
	}
}

func (this *KthLargest) Add(val int) int {
	heap.Push(this.h, val)
	for this.h.Len() > this.k {
		heap.Pop(this.h)
	}
	return (*this.h)[0]
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * obj := Constructor(k, nums);
 * param_1 := obj.Add(val);
 */
