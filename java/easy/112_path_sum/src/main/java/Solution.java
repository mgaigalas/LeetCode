import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution class contains solution for LeetCode problem:
 * #112. Path Sum.
 *
 * @author Marius Gaigalas on 13/08/2024
 */
public class Solution {
    /**
     * Given the root of a binary tree and an integer targetSum, returns true if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals targetSum.
     *
     * @param root      root node of a binary tree
     * @param targetSum target sum
     * @return flag indicating if there is a root-to-leaf path adding up to sum
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        final Deque<State> stack = new LinkedList<>();
        stack.push(new State(root, root.val));
        while (!stack.isEmpty()) {
            State state = stack.pop();
            TreeNode left = state.node.left;
            TreeNode right = state.node.right;
            if (left == null && right == null && state.sum == targetSum) {
                return true;
            }

            if (left != null) {
                stack.push(new State(left, state.sum + left.val));
            }

            if (right != null) {
                stack.push(new State(right, state.sum + right.val));
            }
        }
        return false;
    }

    private record State(TreeNode node, int sum) {
    }
}