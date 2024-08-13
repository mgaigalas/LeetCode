# #404. Sum of Left Leaves

<p>Given the <code>root</code> of a binary tree, return <em>the sum of all left leaves.</em></p>

<p>A <strong>leaf</strong> is a node with no children. A <strong>left leaf</strong> is a leaf that is the left child of another node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="ex1.jpg" style="width: 277px; height: 302px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 24
<strong>Explanation:</strong> There are two left leaves in the binary tree, with values 9 and 15 respectively.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

## Notes

This problem can be solved with DFS by using stacks

```java
import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution class contains solution for LeetCode problem:
 * #404. Sum of Left Leaves.
 *
 * @author Marius Gaigalas on 13/08/2024
 */
public class Solution {
    /**
     * Given the root of a binary tree, returns the sum of all left leaves.
     *
     * @param root root node of a binary tree
     * @return sum of all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        final Deque<State> stack = new LinkedList<>();
        stack.push(new State(root, false));
        while (!stack.isEmpty()) {
            var state = stack.pop();
            var node = state.node;
            if (state.left && node.left == null && node.right == null) {
                res += node.val;
                continue;
            }

            if (node.left != null) {
                stack.push(new State(node.left, true));
            }

            if (node.right != null) {
                stack.push(new State(node.right, false));
            }
        }
        return res;
    }

    private record State(TreeNode node, boolean left) {
    }
}
```