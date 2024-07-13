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
    void plusOne(String name, Args args, int[] want) {
        Assertions.assertArrayEquals(want, toArray(new Solution().plusOne(args.head)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: head = [1,2,3]",
                        new Args(toListNode(new int[]{1, 2, 3})),
                        new int[]{1, 2, 4}),
                Arguments.of(
                        "case: head = [0]",
                        new Args(toListNode(new int[]{0})),
                        new int[]{1}),
                Arguments.of(
                        "case: head = [9,8,7,6,5,4,3,2,1,0]",
                        new Args(toListNode(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})),
                        new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}),
                Arguments.of(
                        "case: head = [9,9,9]",
                        new Args(toListNode(new int[]{9, 9, 9})),
                        new int[]{1, 0, 0, 0}));
    }

    private static ListNode toListNode(int[] digits) {
        final var dummy = new ListNode();
        var node = dummy;
        for (int digit : digits) {
            node.next = new ListNode(digit);
            node = node.next;
        }
        return dummy.next;
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

    record Args(ListNode head) {
    }
}