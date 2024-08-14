import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 14/08/2024
 */
class SolutionTest {
    private static final Integer NULL_VALUE = Integer.MIN_VALUE;

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void findTarget(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().findTarget(args.root, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: root = [5,3,6,2,4,null,7], k = 9",
                        new Args(toTreeNode(List.of(5, 3, 6, 2, 4, NULL_VALUE, 7)), 9),
                        new Expectations(true)),
                Arguments.of(
                        "case: root = [5,3,6,2,4,null,7], k = 28",
                        new Args(toTreeNode(List.of(5, 3, 6, 2, 4, NULL_VALUE, 7)), 28),
                        new Expectations(false)),
                Arguments.of(
                        "case: root = [2,1,3], k = 1",
                        new Args(toTreeNode(List.of(2, 1, 3)), 1),
                        new Expectations(false)),
                Arguments.of(
                        "case: root = [1,0,4,-2,null,3], k = 7",
                        new Args(toTreeNode(List.of(1, 0, 4, -2, NULL_VALUE, 3)), 7),
                        new Expectations(true)));
    }

    private static TreeNode toTreeNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        var index = 0;
        final var root = new TreeNode(values.get(index++));
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (index < values.size() && !values.get(index).equals(NULL_VALUE)) {
                node.left = new TreeNode(values.get(index));
                queue.offer(node.left);
            }
            index++;

            if (index < values.size() && !values.get(index).equals(NULL_VALUE)) {
                node.right = new TreeNode(values.get(index));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }

    record Args(TreeNode root, int k) {
    }

    record Expectations(boolean want) {
    }
}