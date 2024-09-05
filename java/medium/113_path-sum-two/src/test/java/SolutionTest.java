import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 30/08/2024
 */
class SolutionTest {
    private static final Integer NULL_VALUE = -1001;

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void pathSum(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().pathSum(args.root, args.targetSum));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22",
                        new Args(toTreeNode(List.of(5, 4, 8, 11, NULL_VALUE, 13, 4, 7, 2, NULL_VALUE, NULL_VALUE, 5, 1)), 22),
                        new Expectations(List.of(
                                List.of(5, 4, 11, 2),
                                List.of(5, 8, 4, 5)))),
                Arguments.of(
                        "case: root = [1,2,3], targetSum = 5",
                        new Args(toTreeNode(List.of(1, 2, 3)), 5),
                        new Expectations(List.of())),
                Arguments.of(
                        "case: root = [1,2], targetSum = 0",
                        new Args(toTreeNode(List.of(1, 2)), 0),
                        new Expectations(List.of())),
                Arguments.of(
                        "case: root = [], targetSum = 1",
                        new Args(toTreeNode(List.of()), 1),
                        new Expectations(List.of())),
                Arguments.of(
                        "case: root = [-2,null,-3], targetSum = -5",
                        new Args(toTreeNode(List.of(-2, NULL_VALUE, -3)), -5),
                        new Expectations(List.of(List.of(-2, -3)))));
    }

    private static TreeNode toTreeNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        var i = 0;
        final var root = new TreeNode(values.get(i++));
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (i < values.size() && !NULL_VALUE.equals(values.get(i))) {
                node.left = new TreeNode(values.get(i));
                queue.offer(node.left);
            }
            i++;
            if (i < values.size() && !NULL_VALUE.equals(values.get(i))) {
                node.right = new TreeNode(values.get(i));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    record Args(TreeNode root, int targetSum) {
    }

    record Expectations(List<List<Integer>> want) {
    }
}