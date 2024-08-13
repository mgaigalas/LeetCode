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
        return sumOfLeavesInSubtree(root, false);
    }

    /**
     * Recursive method, which returns sums of left leaves of a binary subtree.
     *
     * @param node root node of a subtree
     * @param left flag indicating if node is left node of a binary tree
     * @return sums of left leaves of a binary subtree
     */
    private static int sumOfLeavesInSubtree(TreeNode node, boolean left) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return left ? node.val : 0;
        }
        return sumOfLeavesInSubtree(node.left, true) + sumOfLeavesInSubtree(node.right, false);
    }
}