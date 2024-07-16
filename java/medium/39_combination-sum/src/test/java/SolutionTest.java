import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 13/07/2024
 */
class SolutionTest {
/*    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void addTwoNumbers(String name, Args args, int[] want) {
        Assertions.assertArrayEquals(want, toArray(new Solution().addTwoNumbers(args.l1, args.l2)));
    }*/

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void combinationSum(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.list, new Solution().combinationSum(args.candidates, args.target));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: candidates = [2,3,6,7], target = 7",
                        new Args(new int[]{2, 3, 6, 7}, 7),
                        new Expectations(List.of(
                                List.of(2, 2, 3),
                                List.of(7)))),
                Arguments.of(
                        "case: candidates = [2,3,5], target = 8",
                        new Args(new int[]{2, 3, 5}, 8),
                        new Expectations(List.of(
                                List.of(2, 2, 2, 2),
                                List.of(2, 3, 3),
                                List.of(3, 5)))),
                Arguments.of(
                        "case: candidates = [2], target = 1",
                        new Args(new int[]{2}, 1),
                        new Expectations(List.of())));
    }

    record Args(int[] candidates, int target) {
    }

    record Expectations(List<List<Integer>> list) {
    }
}