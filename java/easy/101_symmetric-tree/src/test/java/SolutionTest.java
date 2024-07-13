import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 12/07/2024
 */
class SolutionTest {
    private static final Integer NULL = Integer.MIN_VALUE;

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void isSymmetric(String name, Args args, boolean want) {
        Assertions.assertEquals(want, new Solution().isSymmetric(args.root));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: root = [1,2,2,3,4,4,3]",
                        new Args(toTreeNode(List.of(1, 2, 2, 3, 4, 4, 3))),
                        true),
                Arguments.of(
                        "case: [1,2,2,null,3,null,3]",
                        new Args(toTreeNode(List.of(1, 2, 2, NULL, 3, NULL, 3))),
                        false)
        );
    }

    private static TreeNode toTreeNode(List<Integer> values) {
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
        if (value.equals(NULL)) {
            return null;
        }
        return new TreeNode(value);
    }

    record Args(TreeNode root) {
    }
}