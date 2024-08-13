import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 13/08/2024
 */
class SolutionTest {
    private static final Integer NULL_VALUE = -101;

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void maxDepth(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().maxDepth(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "root = [3,9,20,null,null,15,7]",
                        new Args(toTreeNode(List.of(3, 9, 20, NULL_VALUE, NULL_VALUE, 15, 7))),
                        new Expectations(3)),
                Arguments.of(
                        "root = [1,null,2]",
                        new Args(toTreeNode(List.of(1, NULL_VALUE, 2))),
                        new Expectations(2)),
                Arguments.of(
                        "root = []",
                        new Args(toTreeNode(List.of())),
                        new Expectations(0)));
    }

    private static TreeNode toTreeNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        var index = 0;
        final TreeNode root = new TreeNode(values.get(index++));
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (index < values.size() && !values.get(index).equals(NULL_VALUE)) {
                node.left = new TreeNode(values.get(index));
                queue.add(node.left);
            }
            index++;

            if (index < values.size() && !values.get(index).equals(NULL_VALUE)) {
                node.right = new TreeNode(values.get(index));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }

    record Args(TreeNode s) {
    }

    record Expectations(int want) {
    }
}