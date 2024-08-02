import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 01/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void getIntersectionNode(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().getIntersectionNode(args.headA, args.headB));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                        List.of(
                                "case: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3",
                                new ListNodeContainerParams(
                                        8,
                                        new int[]{4, 1, 8, 4, 5},
                                        new int[]{5, 6, 1, 8, 4, 5},
                                        2,
                                        3)),
                        List.of(
                                "case: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1",
                                new ListNodeContainerParams(
                                        2,
                                        new int[]{1, 9, 1, 2, 4},
                                        new int[]{3, 2, 4},
                                        3,
                                        1)),
                        List.of("case: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2",
                                new ListNodeContainerParams(
                                        0,
                                        new int[]{2, 6, 4},
                                        new int[]{1, 5},
                                        3,
                                        2)))
                .map(params -> {
                    final var lnc = toListNodeContainer((ListNodeContainerParams) params.get(1));
                    return Arguments.of(
                            params.get(0),
                            new Args(lnc.headA, lnc.headB),
                            new Expectations(lnc.intersectionNode));
                });
    }

    record Args(ListNode headA, ListNode headB) {
    }

    record Expectations(ListNode want) {
    }

    record ListNodeContainer(ListNode headA, ListNode headB, ListNode intersectionNode) {
    }

    record ListNodeContainerParams(
            int intersectVal,
            int[] listA,
            int[] listB,
            int skipA,
            int skipB) {
    }

    private static ListNodeContainer toListNodeContainer(ListNodeContainerParams params) {
        if (params.intersectVal == 0) {
            return new ListNodeContainer(
                    buildListNode(params.listA),
                    buildListNode(params.listB),
                    null);
        }

        var skipA = params.skipA;
        var skipB = params.skipB;
        var dummyA = new ListNode();
        var dummyB = new ListNode();
        var nodeA = dummyA;
        var nodeB = dummyB;
        var idxA = 0;
        var idxB = 0;
        while (skipA >= 0 || skipB >= 0) {
            if (skipA > 0) {
                nodeA.next = new ListNode(params.listA[idxA++]);
                nodeA = nodeA.next;
            }

            if (skipB > 0) {
                nodeB.next = new ListNode(params.listB[idxB++]);
                nodeB = nodeB.next;
            }

            skipA--;
            skipB--;
        }

        var skip = Math.max(params.skipA, params.skipB);
        var arr = params.listA.length > params.listB.length ? params.listA : params.listB;
        var node = new ListNode(arr[skip]);
        final var intersectingNode = node;
        nodeA.next = node;
        nodeB.next = node;

        for (int i = skip + 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }

        return new ListNodeContainer(
                dummyA.next,
                dummyB.next,
                intersectingNode);
    }

    private static ListNode buildListNode(int[] values) {
        if (values == null || values.length == 0) {
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
}