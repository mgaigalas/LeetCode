# #701. Insert into a Binary Search Tree

<p>You are given the <code>root</code> node of a binary search tree (BST) and a <code>value</code> to insert into the tree. Return <em>the root node of the BST after the insertion</em>. It is <strong>guaranteed</strong> that the new value does not exist in the original BST.</p>

<p><strong>Notice</strong>&nbsp;that there may exist&nbsp;multiple valid ways for the&nbsp;insertion, as long as the tree remains a BST after insertion. You can return <strong>any of them</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="ex1.jpg" style="width: 752px; height: 221px;">
<pre><strong>Input:</strong> root = [4,2,7,1,3], val = 5
<strong>Output:</strong> [4,2,7,1,3,5]
<strong>Explanation:</strong> Another accepted tree is:
<img alt="" src="ex2.jpg" style="width: 352px; height: 301px;">
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [40,20,60,10,30,50,70], val = 25
<strong>Output:</strong> [40,20,60,10,30,50,70,null,null,25]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
<strong>Output:</strong> [4,2,7,1,3,5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in&nbsp;the tree will be in the range <code>[0,&nbsp;10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>8</sup> &lt;= Node.val &lt;= 10<sup>8</sup></code></li>
	<li>All the values <code>Node.val</code> are <strong>unique</strong>.</li>
	<li><code>-10<sup>8</sup> &lt;= val &lt;= 10<sup>8</sup></code></li>
	<li>It's <strong>guaranteed</strong> that <code>val</code> does not exist in the original BST.</li>
</ul>

## Notes

Easiest way to solve this is by using recursion, however, that would require ```O(n)``` space complexity as each 
function call would be stored as a separate entry on a stack

```go
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

	if val > root.Val {
		root.Right = insertIntoBST(root.Right, val)
	} else {
		root.Left = insertIntoBST(root.Left, val)
	}
	return root
}
```