import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #530. Minimum Absolute Difference in BST.
 *
 * @author Marius Gaigalas on 13/08/2024
 */
public class Solution {
    /**
     * Given the root of a Binary Search Tree (BST), returns the minimum absolute difference between the values
     * of any two different nodes in the tree.
     *
     * @param root root of a binary search tree
     * @return minimum absolute difference between the values of any two different nodes in the tree
     */
    public int getMinimumDifference(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, Math.abs(list.get(i - 1) - list.get(i)));
        }
        return res;
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }
}