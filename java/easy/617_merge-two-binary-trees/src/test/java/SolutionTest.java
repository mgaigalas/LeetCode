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
    private static final Integer NULL_VALUE = Integer.MIN_VALUE;

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void mergeTrees(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().mergeTrees(args.root1, args.root2));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]",
                        new Args(
                                toTreeNode(List.of(1, 3, 2, 5)),
                                toTreeNode(List.of(2, 1, 3, NULL_VALUE, 4, NULL_VALUE, 7))),
                        new Expectations(toTreeNode(List.of(3, 4, 5, 5, 4, NULL_VALUE, 7)))),
                Arguments.of(
                        "case: root1 = [1], root2 = [1,2]",
                        new Args(
                                toTreeNode(List.of(1)),
                                toTreeNode(List.of(1, 2))),
                        new Expectations(toTreeNode(List.of(2, 2)))));
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

    record Args(TreeNode root1, TreeNode root2) {
    }

    record Expectations(TreeNode want) {
    }
}