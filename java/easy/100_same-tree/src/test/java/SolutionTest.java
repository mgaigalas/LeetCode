import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 13/07/2024
 */
class SolutionTest {
    private static final Integer NULL_VALUE = Integer.MIN_VALUE;

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void isSameTree(String name, Args args, boolean want) {
        Assertions.assertEquals(want, new Solution().isSameTree(args.p, args.q));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: p = [1,2,3], q = [1,2,3]",
                        new Args(toTreeNode(List.of(1, 2, 3)), toTreeNode(List.of(1, 2, 3))),
                        true),
                Arguments.of(
                        "case: p = [1,2], q = [1,null,2]",
                        new Args(toTreeNode(List.of(1, 2)), toTreeNode(List.of(1, NULL_VALUE, 3))),
                        false),
                Arguments.of(
                        "case: p = [1,2,1], q = [1,1,2]",
                        new Args(toTreeNode(List.of(1, 2, 1)), toTreeNode(List.of(1, 1, 2))),
                        false));
    }

    private static TreeNode toTreeNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        var root = new TreeNode(values.getFirst());
        queue.add(root);
        var i = 1;
        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (i < values.size() - 1) {
                node.left = new TreeNode(values.get(i++));
                queue.add(node.left);
            }

            if (i < values.size() - 1) {
                node.right = new TreeNode(values.get(i++));
                queue.add(node.right);
            }
        }
        return root;
    }

    record Args(TreeNode p, TreeNode q) {
    }
}