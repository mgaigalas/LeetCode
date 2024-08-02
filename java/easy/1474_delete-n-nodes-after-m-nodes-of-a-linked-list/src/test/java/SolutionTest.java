import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 02/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void deleteNodes(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, toList(new Solution().deleteNodes(
                args.head,
                args.m,
                args.n)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3",
                        new Args(toListNode(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)), 2, 3),
                        new Expectations(List.of(1, 2, 6, 7, 11, 12))),
                Arguments.of(
                        "case: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3",
                        new Args(toListNode(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)), 1, 3),
                        new Expectations(List.of(1, 5, 9))),
                Arguments.of(
                        "case: head = [6,3,5,6,2,8,9,2,3,4], m = 2, n = 1",
                        new Args(toListNode(List.of(6, 3, 5, 6, 2, 8, 9, 2, 3, 4)), 2, 1),
                        new Expectations(List.of(6, 3, 6, 2, 9, 2, 4))));
    }

    private static ListNode toListNode(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }

        final var dummy = new ListNode();
        var node = dummy;
        for (var val : values) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return dummy.next;
    }

    private List<Integer> toList(ListNode head) {
        final List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    record Args(ListNode head, int m, int n) {
    }

    record Expectations(List<Integer> want) {
    }
}