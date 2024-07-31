import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 31/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void hasCycle(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().hasCycle(args.head));
    }

    static Stream<Arguments> argumentSource() throws IOException {
        final var ec = new ObjectMapper().readValue(
                SolutionTest.class.getResourceAsStream("/case-01.json"),
                ExternalCase.class);

        return Stream.of(
                Arguments.of(
                        "case: head = [3,2,0,-4], pos = 1",
                        new Args(toListNode(new int[]{3, 2, 0, -4}, 1)),
                        new Expectations(true)),
                Arguments.of(
                        "case: head = [1,2], pos = 0",
                        new Args(toListNode(new int[]{1, 2}, 0)),
                        new Expectations(true)),
                Arguments.of(
                        "case: head = [1], pos = -1",
                        new Args(toListNode(new int[]{1}, -1)),
                        new Expectations(false)),
                Arguments.of(
                        "case: head = [1,2], pos = -1",
                        new Args(toListNode(new int[]{1, 2}, -1)),
                        new Expectations(false)),
                Arguments.of(
                        ec.name,
                        new Args(toListNode(ec.args.values, ec.args.pos)),
                        ec.expectations),
                Arguments.of(
                        "case: head = [1,1,1,1], pos = -1",
                        new Args(toListNode(new int[]{1, 1, 1, 1}, -1)),
                        new Expectations(false)));
    }

    record Args(ListNode head) {
    }

    record Expectations(boolean want) {
    }

    record ExternalCase(String name, ExternalArgs args, Expectations expectations) {
    }

    record ExternalArgs(int[] values, int pos) {
    }

    private static ListNode toListNode(int[] values, int pos) {
        final var dummy = new ListNode();
        var node = dummy;
        ListNode posNode = null;
        var currPos = 0;
        for (var val : values) {
            node.next = new ListNode(val);
            node = node.next;
            if (currPos == pos) {
                posNode = node;
            }
            currPos++;
        }

        if (posNode != null) {
            node.next = posNode;
        }
        return dummy.next;
    }
}