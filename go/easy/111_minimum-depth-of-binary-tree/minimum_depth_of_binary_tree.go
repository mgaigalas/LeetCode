// Package mindepthofbinarytree contains solution for LeetCode problem: #111. Minimum Depth of Binary Tree.
package mindepthofbinarytree

// TreeNode represents node of a binary tree.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// minDepth returns minimum depth of a binary tree.
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	depth := 1
	queue := make([]*TreeNode, 1)
	queue[0] = root
	for len(queue) > 0 {
		length := len(queue)
		for i := 0; i < length; i++ {
			node := queue[0]
			queue = queue[1:]

			left := node.Left
			right := node.Right
			if left == nil && right == nil {
				return depth
			}

			if left != nil {
				queue = append(queue, left)
			}

			if right != nil {
				queue = append(queue, right)
			}
		}
		depth++
	}
	return -1
}
