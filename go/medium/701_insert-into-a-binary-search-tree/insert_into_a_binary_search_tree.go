// Package insertintoabinarysearchtree contains solution for LeetCode problem: #701. Insert into a Binary Search Tree.
package insertintoabinarysearchtree

// TreeNode represents node of a binary tree.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// insertIntoBST returns the root node of the BST after the insertion.
func insertIntoBST(root *TreeNode, val int) *TreeNode {
	if root == nil {
		return &TreeNode{
			Val: val,
		}
	}

	node := root
	for node != nil {
		if val > node.Val {
			if node.Right == nil {
				node.Right = &TreeNode{
					Val: val,
				}
				break
			}
			node = node.Right
		} else {
			if node.Left == nil {
				node.Left = &TreeNode{
					Val: val,
				}
				break
			}
			node = node.Left
		}
	}
	return root
}
