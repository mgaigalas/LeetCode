import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 13/07/2024
 */
class SolutionTest {
    private static final Integer NULL_VALUE = Integer.MIN_VALUE;
    private static final TreeNode NULL_NODE = new TreeNode(NULL_VALUE);

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void invertTree(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.list, toArray(new Solution().invertTree(args.root)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: root = [4,2,7,1,3,6,9]",
                        new Args(toTreeNode(List.of(4, 2, 7, 1, 3, 6, 9))),
                        new Expectations(List.of(4, 7, 2, 9, 6, 3, 1))),
                Arguments.of(
                        "case: root = []",
                        new Args(toTreeNode(List.of())),
                        new Expectations(List.of())),
                Arguments.of(
                        "case: root = [1,2]",
                        new Args(toTreeNode(List.of(1, 2))),
                        new Expectations(List.of(1, NULL_VALUE, 2))));
    }

    private static List<Integer> toArray(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        final List<Integer> list = new ArrayList<>();
        final Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            var node = stack.poll();
            list.add(node.val);

            var left = node.left;
            var right = node.right;
            if (left == null && right == null) {
                continue;
            }

            stack.add(Objects.requireNonNullElse(left, NULL_NODE));
            stack.add(Objects.requireNonNullElse(right, NULL_NODE));
        }
        return list;
    }

    private static TreeNode toTreeNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        final var root = new TreeNode(values.getFirst());
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        var i = 1;
        while (!queue.isEmpty()) {
            var node = queue.poll();
            node.left = createNode(values, i++);
            if (node.left != null) {
                queue.offer(node.left);
            }
            node.right = createNode(values, i++);
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    private static TreeNode createNode(List<Integer> values, int idx) {
        if (values.size() - 1 < idx) {
            return null;
        }

        var value = values.get(idx);
        if (value.equals(NULL_VALUE)) {
            return null;
        }
        return new TreeNode(value);
    }

    record Args(TreeNode root) {
    }

    record Expectations(List<Integer> list) {
    }
}