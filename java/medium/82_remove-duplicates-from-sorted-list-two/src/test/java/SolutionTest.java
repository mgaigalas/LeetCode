import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 06/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void deleteDuplicates(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, toList(new Solution().deleteDuplicates(args.head)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: head = [1,2,3,3,4,4,5]",
                        new Args(toListNode(List.of(1, 2, 3, 3, 4, 4, 5))),
                        new Expectations(List.of(1, 2, 5))),
                Arguments.of(
                        "case: head = [1,1,1,2,3]",
                        new Args(toListNode(List.of(1, 1, 1, 2, 3))),
                        new Expectations(List.of(2, 3))));
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

    record Args(ListNode head) {
    }

    record Expectations(List<Integer> want) {
    }
}