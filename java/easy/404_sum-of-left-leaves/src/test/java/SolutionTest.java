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
    private static final Integer NULL_VALUE = -1001;

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void sumOfLeftLeaves(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().sumOfLeftLeaves(args.root));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: root = [3,9,20,null,null,15,7]",
                        new Args(toTreeNode(List.of(3, 9, 20, NULL_VALUE, NULL_VALUE, 15, 7))),
                        new Expectations(24)),
                Arguments.of(
                        "case: root = [1]",
                        new Args(toTreeNode(List.of(1))),
                        new Expectations(0)),
                Arguments.of(
                        "case: root = [1,2]",
                        new Args(toTreeNode(List.of(1, 2))),
                        new Expectations(2)));
    }

    private static TreeNode toTreeNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        var index = 0;
        final var root = new TreeNode(values.get(index++));
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

    record Args(TreeNode root) {
    }

    record Expectations(int want) {
    }
}