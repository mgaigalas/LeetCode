// Package diameterofbinarytree contains solution for LeetCode problem: #543. Diameter of Binary Tree.
package diameterofbinarytree

// TreeNode represents node of a binary tree.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// diameterOfBinaryTree given the root of a binary tree, returns the length of the diameter of the tree.
func diameterOfBinaryTree(root *TreeNode) int {
	var diameter int
	nodeLength(root, &diameter)
	return diameter
}

func nodeLength(node *TreeNode, diameter *int) int {
	if node == nil {
		return 0
	}

	left := nodeLength(node.Left, diameter)
	right := nodeLength(node.Right, diameter)
	*diameter = max(*diameter, left+right)
	return max(left, right) + 1
}
