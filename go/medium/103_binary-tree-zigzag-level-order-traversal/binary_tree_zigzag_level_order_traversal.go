// Package binarytreezigzaglevelordertraversal contains solution for LeetCode problem: #103. Binary Tree Zigzag Level
// Order Traversal.
package binarytreezigzaglevelordertraversal

import "container/list"

// TreeNode represents node of a binary tree.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// zigzagLevelOrder given the root of a binary tree, returns the zigzag level order traversal of its nodes' values.
// (i.e., from left to right, then right to left for the next level and alternate between).
func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return make([][]int, 0)
	}

	res := make([][]int, 0)
	shouldReverse := false
	queue := list.New()
	queue.PushBack(root)
	for queue.Len() > 0 {
		length := queue.Len()
		entry := make([]int, 0, length)

		for i := 0; i < length; i++ {
			if !shouldReverse {
				element := queue.Front()
				node := element.Value.(*TreeNode)
				queue.Remove(element)
				entry = append(entry, node.Val)

				if node.Left != nil {
					queue.PushBack(node.Left)
				}
				if node.Right != nil {
					queue.PushBack(node.Right)
				}
			} else {
				element := queue.Back()
				node := element.Value.(*TreeNode)
				queue.Remove(element)
				entry = append(entry, node.Val)

				if node.Right != nil {
					queue.PushFront(node.Right)
				}
				if node.Left != nil {
					queue.PushFront(node.Left)
				}
			}
		}
		shouldReverse = !shouldReverse
		res = append(res, entry)
	}
	return res
}
