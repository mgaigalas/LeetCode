// Package deepestleavessum contains solution for LeetCode problem: #1302. Deepest Leaves Sum.
package deepestleavessum

// TreeNode represents node of a binary tree.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// deepestLeavesSum given the root of a binary tree, returns the sum of values of its deepest leaves.
func deepestLeavesSum(root *TreeNode) int {
	var maxDepth, sum int
	var dfs func(node *TreeNode, depth int)
	dfs = func(node *TreeNode, depth int) {
		if node == nil {
			return
		}

		if depth > maxDepth {
			maxDepth = depth
			sum = node.Val
		} else if depth == maxDepth {
			sum += node.Val
		}

		dfs(node.Left, depth+1)
		dfs(node.Right, depth+1)
	}
	dfs(root, 0)

	return sum
}
