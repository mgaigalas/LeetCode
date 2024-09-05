/**
 * TreeNode represents a node in a custom tree.
 * NOTE: this class was provided by LeetCode.
 *
 * @author Marius Gaigalas on 30/08/2024
 */
@SuppressWarnings("unused")
public final class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
