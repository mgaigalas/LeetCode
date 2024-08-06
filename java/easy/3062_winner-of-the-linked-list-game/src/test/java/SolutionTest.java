import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 06/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void gameResult(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().gameResult(args.head));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: head = [2,1]",
                        new Args(toListNode(List.of(2, 1))),
                        new Expectations("Even")),
                Arguments.of(
                        "case: head = [2,5,4,7,20,5]",
                        new Args(toListNode(List.of(2, 5, 4, 7, 20, 5))),
                        new Expectations("Odd")),
                Arguments.of(
                        "case: head = [4,5,2,1]",
                        new Args(toListNode(List.of(4, 5, 2, 1))),
                        new Expectations("Tie")));
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

    record Args(ListNode head) {
    }

    record Expectations(String want) {
    }
}