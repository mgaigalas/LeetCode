# #111. Minimum Depth of Binary Tree

<p>Given a binary tree, find its minimum depth.</p>

<p>The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.</p>

<p><strong>Note:</strong>&nbsp;A leaf is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="ex1.jpg" style="width: 432px; height: 302px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [2,null,3,null,4,null,5,null,6]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>5</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

## Notes

Golang has no implementation of queue required to do BFS, therefore this can either be solved by using slices without 
pre-allocated size (as graph size is unknown), which will force memory re-allocation and underlying array copy each time 
it exceeds its capacity. Additionally, there is a huge overhead with slicing from a beginning of slice, which, again, 
forces re-allocation sooner or later as each new pop from a front will shrink underlying array from a beginning. More 
nodes graph has - less efficient it will become, therefore a linked list can be used as a queue implementation. 
This has overhead by its own, as each element is being wrapped, unwrapped and assigned to its own pointer. This is more 
efficient if there are a lot of nodes in a graph. Additionally, since elements are being inserted at a end and removed 
from a front - operations are ```O(1)``` runtime complexity

```go
// Package mindepthofbinarytree contains solution for LeetCode problem: #111. Minimum Depth of Binary Tree.
package mindepthofbinarytree

import "container/list"

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
	queue := list.New()
	queue.PushBack(root)
	for queue.Len() > 0 {
		length := queue.Len()

		for i := 0; i < length; i++ {
			element := queue.Front()
			node := element.Value.(*TreeNode)
			queue.Remove(element)
			left := node.Left
			right := node.Right
			if left == nil && right == nil {
				return depth
			}

			if left != nil {
				queue.PushBack(left)
			}

			if right != nil {
				queue.PushBack(right)
			}
		}
		depth++
	}
	return -1
}
```