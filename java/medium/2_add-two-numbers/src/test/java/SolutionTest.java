import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 10/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void addTwoNumbers(String name, Args args, int[] want) {
        Assertions.assertArrayEquals(want, toArray(new Solution().addTwoNumbers(args.l1, args.l2)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: l1 = [2,4,3], l2 = [5,6,4]",
                        new Args(toListNode(new int[]{2, 4, 3}), toListNode(new int[]{5, 6, 4})),
                        new int[]{7, 0, 8}),
                Arguments.of(
                        "case: l1 = [0], l2 = [0]",
                        new Args(toListNode(new int[]{0}), toListNode(new int[]{0})),
                        new int[]{0}),
                Arguments.of(
                        "case: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]",
                        new Args(toListNode(new int[]{9, 9, 9, 9, 9, 9, 9}), toListNode(new int[]{9, 9, 9, 9})),
                        new int[]{8, 9, 9, 9, 0, 0, 0, 1}));
    }

    private int[] toArray(ListNode head) {
        final List<Integer> list = new ArrayList<>();
        var node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list.stream()
                .mapToInt(v -> v)
                .toArray();
    }

    private static ListNode toListNode(int[] arr) {
        final var dummy = new ListNode(Integer.MIN_VALUE);
        var node = dummy;
        for (int num : arr) {
            node.next = new ListNode(num);
            node = node.next;
        }

        return dummy.next;
    }

    record Args(ListNode l1, ListNode l2) {
    }
}