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
    void hasPathSum(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().hasPathSum(args.root, args.targetSum));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22",
                        new Args(
                                toTreeNode(List.of(
                                        5,
                                        4,
                                        8,
                                        11,
                                        NULL_VALUE,
                                        13,
                                        4,
                                        7,
                                        2,
                                        NULL_VALUE,
                                        NULL_VALUE,
                                        NULL_VALUE,
                                        1)),
                                22),
                        new Expectations(true)),
                Arguments.of(
                        "root = [1,2,3], targetSum = 5",
                        new Args(
                                toTreeNode(List.of(
                                        1,
                                        2,
                                        3)),
                                5),
                        new Expectations(false)),
                Arguments.of(
                        "root = [], targetSum = 0",
                        new Args(
                                toTreeNode(List.of()),
                                0),
                        new Expectations(false)),
                Arguments.of(
                        "root = [1,2], targetSum = 1",
                        new Args(
                                toTreeNode(List.of(
                                        1,
                                        2)),
                                1),
                        new Expectations(false)));
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

    record Args(TreeNode root, int targetSum) {
    }

    record Expectations(boolean want) {
    }
}