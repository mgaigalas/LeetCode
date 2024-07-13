import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution class contains solution for LeetCode problem:
 * #226. Invert Binary Tree.
 *
 * @author Marius Gaigalas on 13/07/2024
 */
public class Solution {
    /**
     * Given the root of a binary tree, inverts the tree, and returns its root.
     *
     * @param root root node of a tree
     * @return root node of an inverted tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var node = stack.pop();
            var left = node.left;
            var right = node.right;
            node.left = right;
            node.right = left;

            if (left != null) {
                stack.push(left);
            }

            if (right != null) {
                stack.push(right);
            }
        }
        return root;
    }
}