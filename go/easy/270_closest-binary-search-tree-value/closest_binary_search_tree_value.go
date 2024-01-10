// Package closestbinarysearchtreevalue contains solution for LeetCode problem: #270. Closest Binary Search Tree Value.
package closestbinarysearchtreevalue

import "math"

// TreeNode represents node of a binary tree.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// closestValue given the root of a binary search tree and a target value, returns the value in the BST that is closest
// to the target. If there are multiple answers, print the smallest.
func closestValue(root *TreeNode, target float64) int {
	if root == nil {
		return 0
	}

	res := math.MaxInt64
	minDiff := math.MaxFloat64
	for root != nil {
		currDiff := float64(root.Val) - target
		if currDiff == 0 {
			return root.Val
		}

		absCurrDiff := abs(currDiff)
		if absCurrDiff < minDiff {
			minDiff = absCurrDiff
			res = root.Val
		} else if absCurrDiff == minDiff {
			res = min(res, root.Val)
		}

		if currDiff > 0 {
			root = root.Left
		} else {
			root = root.Right
		}
	}
	return res
}

func abs(val float64) float64 {
	if val < 0 {
		return -val
	}
	return val
}
