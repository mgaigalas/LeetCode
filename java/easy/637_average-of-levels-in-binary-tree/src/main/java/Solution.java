import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution class contains solution for LeetCode problem:
 * #637. Average of Levels in Binary Tree.
 *
 * @author Marius Gaigalas on 13/08/2024
 */
public class Solution {
    /**
     * Given the root of a binary tree, returns the average value of the nodes on each level in the form of an array.
     *
     * @param root root node of a binary tree
     * @return average values of each level of binary tree
     */
    @SuppressWarnings("DataFlowIssue")
    public List<Double> averageOfLevels(TreeNode root) {
        final List<Double> list = new LinkedList<>();
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0.d;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(sum / ((double) n));
        }
        return list;
    }
}