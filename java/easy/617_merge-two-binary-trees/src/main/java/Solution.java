import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution class contains solution for LeetCode problem:
 * #617. Merge Two Binary Trees.
 *
 * @author Marius Gaigalas on 13/08/2024
 */
public class Solution {
    /**
     * Returns merged tree.
     *
     * @param root1 root node of binary tree
     * @param root2 root node of binary tree
     * @return root node of merged binary tree
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        final Deque<State> stack = new LinkedList<>();
        stack.push(new State(root1, root2));
        while (!stack.isEmpty()) {
            State state = stack.pop();
            TreeNode node1 = state.node1;
            TreeNode node2 = state.node2;
            if (node2 == null) {
                continue;
            }
            node1.val += node2.val;

            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                stack.push(new State(node1.left, node2.left));
            }

            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                stack.push(new State(node1.right, node2.right));
            }
        }

        return root1;
    }

    private record State(TreeNode node1, TreeNode node2) {
    }
}