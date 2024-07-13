import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 12/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void solution(String name, Args args, Expectations want) {
        var i = 0;
        Solution objectUnderTest = null;
        for (OperationType op : args.operations) {
            switch (op) {
                case CREATE_OBJ -> objectUnderTest = new Solution();
                case PUSH -> Objects.requireNonNull(objectUnderTest).push(args.nums[i][0]);
                case POP -> Assertions.assertEquals(want.objects[i], Objects.requireNonNull(objectUnderTest).pop());
                case PEEK -> Assertions.assertEquals(want.objects[i], Objects.requireNonNull(objectUnderTest).peek());
                case EMPTY -> Assertions.assertEquals(want.objects[i], Objects.requireNonNull(objectUnderTest).empty());
            }
            i++;
        }
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        """
                                case: ["MyQueue", "push", "push", "peek", "pop", "empty"]
                                [[], [1], [2], [], [], []]
                                """,
                        new Args(
                                new OperationType[]{
                                        OperationType.CREATE_OBJ,
                                        OperationType.PUSH,
                                        OperationType.PUSH,
                                        OperationType.PEEK,
                                        OperationType.POP,
                                        OperationType.EMPTY},
                                new int[][]{{}, {1}, {2}, {}, {}, {}}),
                        new Expectations(new Object[]{null, null, null, 1, 1, Boolean.FALSE})),
                Arguments.of(
                        """
                                case: ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
                                [[],[1],[2],[3],[4],[],[5],[],[],[],[]]
                                """,
                        new Args(
                                new OperationType[]{
                                        OperationType.CREATE_OBJ,
                                        OperationType.PUSH,
                                        OperationType.PUSH,
                                        OperationType.PUSH,
                                        OperationType.PUSH,
                                        OperationType.POP,
                                        OperationType.PUSH,
                                        OperationType.POP,
                                        OperationType.POP,
                                        OperationType.POP,
                                        OperationType.POP},
                                new int[][]{{}, {1}, {2}, {3}, {4}, {}, {5}, {}, {}, {}, {}}),
                        new Expectations(new Object[]{null, null, null, null, null, 1, null, 2, 3, 4, 5})));
    }

    private record Args(OperationType[] operations, int[][] nums) {
    }

    private record Expectations(Object[] objects) {
    }

    private enum OperationType {
        CREATE_OBJ,
        PUSH,
        PEEK,
        POP,
        EMPTY
    }
}