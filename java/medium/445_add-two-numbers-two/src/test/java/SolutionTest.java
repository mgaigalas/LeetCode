import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 11/07/2024
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
                        "case: l1 = [7,2,4,3], l2 = [5,6,4]",
                        new Args(toListNode(new int[]{7, 2, 4, 3}), toListNode(new int[]{5, 6, 4})),
                        new int[]{7, 8, 0, 7}),
                Arguments.of(
                        "case: l1 = [2,4,3], l2 = [5,6,4]",
                        new Args(toListNode(new int[]{2, 4, 3}), toListNode(new int[]{5, 6, 4})),
                        new int[]{8, 0, 7}),
                Arguments.of(
                        "case: l1 = [0], l2 = [0]",
                        new Args(toListNode(new int[]{0}), toListNode(new int[]{0})),
                        new int[]{0}),
                Arguments.of(
                        "case: l1 = [5], l2 = [5]",
                        new Args(toListNode(new int[]{5}), toListNode(new int[]{5})),
                        new int[]{1, 0}),
                Arguments.of(
                        "case: l1 = [1,6,0,3,3,6,7,2,0,1], l2 = [6,3,0,8,9,6,6,9,6,1]",
                        new Args(toListNode(new int[]{1, 6, 0, 3, 3, 6, 7, 2, 0, 1}), toListNode(new int[]{6, 3, 0, 8, 9, 6, 6, 9, 6, 1})),
                        new int[]{7, 9, 1, 2, 3, 3, 4, 1, 6, 2}));
    }

    private int[] toArray(ListNode head) {
        final List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list.stream()
                .mapToInt(v -> v)
                .toArray();
    }

    private static ListNode toListNode(int[] digits) {
        var dummy = new ListNode();
        var node = dummy;
        for (int digit : digits) {
            node.next = new ListNode(digit);
            node = node.next;
        }
        return dummy.next;
    }

    record Args(ListNode l1, ListNode l2) {
    }
}