import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #653. Two Sum IV - Input is a BST.
 *
 * @author Marius Gaigalas on 14/08/2024
 */
public class Solution {
    /**
     * Given the root of a binary search tree and an integer k, returns true if there exist two elements in the BST
     * such that their sum is equal to k, or false otherwise.
     *
     * @param root root node of a binary search tree
     * @param k    target sum
     * @return flag indicating if there exist two elements in the BST such that their sum is equal to k
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        final List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(right) + list.get(left) == k) {
                return true;
            }

            if (k - list.get(right) > list.get(left)) {
                left++;
                continue;
            }
            right--;
        }
        return false;
    }

    /**
     * Method which traverses through binary search tree in-order and saves its values to a list.
     * Result - sorted list.
     *
     * @param node root node of a binary search tree
     * @param list target list, which is used to store values from binary search tree
     */
    private static void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }
}