/**
 * Solution class contains solution for LeetCode problem:
 * #101. Symmetric Tree.
 *
 * @author Marius Gaigalas on 12/07/2024
 */
public class Solution {
    /**
     * Given the root of a binary tree, checks whether it is a mirror of itself (i.e., symmetric around its center).
     *
     * @param root root node of a binary tree
     * @return flag indicating if binary tree is symmetric.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return areSymmetric(root.left, root.right);
    }

    private static boolean areSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
    }
}