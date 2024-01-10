// Package maxdiffbetweennodeandancestor contains solution for LeetCode problem: #1026. Maximum Difference Between
// Node and Ancestor.
package maxdiffbetweennodeandancestor

// TreeNode represents node of a binary tree.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// maxAncestorDiff given the root of a binary tree, finds the maximum value v for which there exist different
// nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
func maxAncestorDiff(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return ancestorDiff(root, root.Val, root.Val)
}

func ancestorDiff(node *TreeNode, currMin, currMax int) int {
	if node == nil {
		return currMax - currMin
	}

	currMin = min(currMin, node.Val)
	currMax = max(currMax, node.Val)
	left := ancestorDiff(node.Left, currMin, currMax)
	right := ancestorDiff(node.Right, currMin, currMax)
	return max(left, right)
}
