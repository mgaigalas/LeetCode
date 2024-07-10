import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 09/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void mergeNodes(String name, Args args, int[] want) {
        final var got = new Solution().mergeNodes(args.head);
        Assertions.assertArrayEquals(want, toArray(got));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: head = [0,3,1,0,4,5,2,0]",
                        toArgs(new int[]{0, 3, 1, 0, 4, 5, 2, 0}),
                        new int[]{4, 11}),
                Arguments.of(
                        "case: head = [0,1,0,3,0,2,2,0]",
                        toArgs(new int[]{0, 1, 0, 3, 0, 2, 2, 0}),
                        new int[]{1, 3, 4}));
    }

    private static Args toArgs(int[] arr) {
        if (arr.length == 0) {
            return new Args(null);
        }

        var node = new ListNode(arr[0]);
        var head = node;
        for (int i = 1; i < arr.length; i++) {
            var next = new ListNode(arr[i]);
            node.next = next;
            node = next;
        }

        return new Args(head);
    }

    private static int[] toArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        final List<Integer> list = new ArrayList<>();
        var node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list.stream()
                .mapToInt(value -> value)
                .toArray();
    }

    record Args(ListNode head) {
    }
}