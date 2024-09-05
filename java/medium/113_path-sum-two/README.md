# #113. Path Sum II

<p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>all <strong>root-to-leaf</strong> paths where the sum of the node values in the path equals </em><code>targetSum</code><em>. Each path should be returned as a list of the node <strong>values</strong>, not node references</em>.</p>

<p>A <strong>root-to-leaf</strong> path is a path starting from the root and ending at any leaf node. A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="ex1.jpg" style="width: 500px; height: 356px;">
<pre><strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>Output:</strong> [[5,4,11,2],[5,8,4,5]]
<strong>Explanation:</strong> There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="ex2.jpg" style="width: 212px; height: 181px;">
<pre><strong>Input:</strong> root = [1,2,3], targetSum = 5
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> root = [1,2], targetSum = 0
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
</ul>

## Notes

Naive way to solve this kind of problem would be backtracking on each step.

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #113. Path Sum II.
 *
 * @author Marius Gaigalas on 30/08/2024
 */
public class Solution {
    /**
     * Given the root of a binary tree and an integer targetSum, returns all root-to-leaf paths where
     * the sum of the node values in the path equals targetSum.
     *
     * @param root      root node
     * @param targetSum target sum
     * @return list of node values indicating path from root node to its leaves
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return List.of();
        }

        final List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(root.val);
        dfs(curr, list, root, targetSum - root.val);
        return list;
    }

    /**
     * Utility function, which uses Depth-First Search with Backtracking to find path from current node to leaf node.
     *
     * @param curr      list with current nodes visited
     * @param list      final list containing valid paths as node values
     * @param node      current node
     * @param targetSum target sum from current node
     */
    private static void dfs(List<Integer> curr, List<List<Integer>> list, TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }

        if (targetSum == 0 && node.left == null && node.right == null) {
            list.add(new ArrayList<>(curr));
            return;
        }

        if (node.left != null) {
            curr.add(node.left.val);
            dfs(curr, list, node.left, targetSum - node.left.val);
            curr.remove(curr.size() - 1);
        }

        if (node.right != null) {
            curr.add(node.right.val);
            dfs(curr, list, node.right, targetSum - node.right.val);
            curr.remove(curr.size() - 1);
        }
    }
}
```