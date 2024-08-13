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
    void getMinimumDifference(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().getMinimumDifference(args.root));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: root = [4,2,6,1,3]",
                        new Args(toTreeNode(List.of(4, 2, 6, 1, 3))),
                        new Expectations(1)),
                Arguments.of(
                        "case: root = [1,0,48,null,null,12,49]",
                        new Args(toTreeNode(List.of(1, 0, 48, NULL_VALUE, NULL_VALUE, 12, 49))),
                        new Expectations(1)),
                Arguments.of(
                        "case: root = [236,104,701,null,227,null,911]",
                        new Args(toTreeNode(List.of(236, 104, 701, NULL_VALUE, 227, NULL_VALUE, 911))),
                        new Expectations(9)));
    }

    private static TreeNode toTreeNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        var index = 0;
        var root = new TreeNode(values.get(index++));
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