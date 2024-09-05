import java.util.ArrayList;
import java.util.LinkedList;
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
        dfs(new LinkedList<>(), list, root, targetSum);
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
        curr.add(node.val);

        if (targetSum == node.val && node.left == null && node.right == null) {
            list.add(new ArrayList<>(curr));
        } else {
            dfs(curr, list, node.left, targetSum - node.val);
            dfs(curr, list, node.right, targetSum - node.val);
        }
        curr.remove(curr.size() - 1);
    }
}