import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution class contains solution for LeetCode problem:
 * #104. Maximum Depth of Binary Tree.
 *
 * @author Marius Gaigalas on 13/08/2024
 */
public class Solution {
    /**
     * Given the root of a binary tree, returns its maximum depth.
     *
     * @param root root of a binary tree
     * @return maximum depth of a binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        final Deque<State> stack = new LinkedList<>();
        stack.push(new State(root, 1));
        while (!stack.isEmpty()) {
            var state = stack.pop();
            var node = state.node;
            if (node.left == null && node.right == null) {
                res = Math.max(res, state.depth);
                continue;
            }

            if (node.left != null) {
                stack.push(new State(node.left, state.depth + 1));
            }

            if (node.right != null) {
                stack.push(new State(node.right, state.depth + 1));
            }
        }
        return res;
    }

    private record State(TreeNode node, int depth) {
    }
}