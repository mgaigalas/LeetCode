import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 30/05/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void insertionSortList(String name, Args args, int[] want) {
        final var got = new Solution().insertionSortList(args.head());
        Assertions.assertArrayEquals(want, toArray(got));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: head = [4,2,1,3]",
                        toArgs(new int[]{4, 2, 1, 3}),
                        new int[]{1, 2, 3, 4}),
                Arguments.of(
                        "case: head = [-1,5,3,4,0]",
                        toArgs(new int[]{-1, 5, 3, 4, 0}),
                        new int[]{-1, 0, 3, 4, 5}));
    }

    private static Args toArgs(int[] arr) {
        if (arr.length == 0) {
            return new Args(null);
        }

        var node = new ListNode(arr[0]);
        node.val = arr[0];
        final var head = node;
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

        final var list = new ArrayList<Integer>();
        ListNode node = head;
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