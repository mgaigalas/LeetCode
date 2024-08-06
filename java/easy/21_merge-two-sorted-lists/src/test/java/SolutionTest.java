import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 18/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void mergeTwoLists(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, toList(new Solution().mergeTwoLists(args.list1, args.list2)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: list1 = [1,2,4], list2 = [1,3,4]",
                        new Args(toListNode(List.of(1, 2, 4)), toListNode(List.of(1, 3, 4))),
                        new Expectations(List.of(1, 1, 2, 3, 4, 4))),
                Arguments.of(
                        "case: list1 = [], list2 = []",
                        new Args(toListNode(List.of()), toListNode(List.of())),
                        new Expectations(List.of())),
                Arguments.of(
                        "case: list1 = [], list2 = [0]",
                        new Args(toListNode(List.of()), toListNode(List.of(0))),
                        new Expectations(List.of(0))));
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

    private static List<Integer> toList(ListNode head) {
        final List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    record Args(ListNode list1, ListNode list2) {
    }

    record Expectations(List<Integer> want) {
    }
}