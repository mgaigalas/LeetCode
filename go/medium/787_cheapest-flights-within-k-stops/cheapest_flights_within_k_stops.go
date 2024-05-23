// Package cheapestflightswithinkstops contains solution for LeetCode problem: #787. Cheapest Flights Within K stops.
package cheapestflightswithinkstops

import "container/heap"

// HeapNode is a data structure representing state data about point in flight.
type HeapNode struct {
	id       int
	distance int
	stops    int
}

// Heap is a data structure representing min Heap.
type Heap []*HeapNode

// Len is the number of elements in the collection. This is implementation of sort interface.
func (h *Heap) Len() int {
	return len(*h)
}

// Less returns if ith element is less than jth element. This is implementation of sort interface.
func (h *Heap) Less(i, j int) bool {
	return (*h)[i].distance < (*h)[j].distance
}

// Swap swaps the elements with indexes i and j. This is implementation of sort interface.
func (h *Heap) Swap(i, j int) {
	(*h)[i], (*h)[j] = (*h)[j], (*h)[i]
}

// Push pushes element on a Heap. This is implementation of Heap interface.
func (h *Heap) Push(x any) {
	*h = append(*h, x.(*HeapNode))
}

// Pop pops element from a Heap. This is implementation of Heap interface.
func (h *Heap) Pop() any {
	n := h.Len()
	x := (*h)[n-1]
	*h = (*h)[:n-1]
	return x
}

// findCheapestPrice returns cheapest price from src to dst.
func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {
	h := make(Heap, 0)
	heap.Init(&h)

	graph := make([][]HeapNode, n)
	for _, flight := range flights {
		from := flight[0]
		to := flight[1]
		price := flight[2]

		graph[from] = append(graph[from], HeapNode{
			id:       to,
			distance: price,
		})
	}

	heap.Push(&h, &HeapNode{
		id:       src,
		distance: 0,
		stops:    k + 1,
	})
	for h.Len() > 0 {
		node := heap.Pop(&h).(*HeapNode)
		if node.id == dst {
			return node.distance
		}

		if node.stops > 0 {
			for _, neigb := range graph[node.id] {
				heap.Push(&h, &HeapNode{
					id:       neigb.id,
					distance: node.distance + neigb.distance,
					stops:    node.stops - 1,
				})
			}
		}
	}
	return -1
}
