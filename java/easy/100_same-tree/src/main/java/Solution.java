/**
 * Solution class contains solution for LeetCode problem:
 * #100. Same Tree.
 *
 * @author Marius Gaigalas on 13/07/2024
 */
public class Solution {
    /**
     * Given the roots of two binary trees p and q, returns flag indicating if they are same.
     *
     * @param p root node of a tree
     * @param q root node of a tree
     * @return flag indicating if trees are same
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}