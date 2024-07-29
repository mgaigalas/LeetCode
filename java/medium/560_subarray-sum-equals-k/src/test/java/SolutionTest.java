import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 29/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void subarraySum(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().subarraySum(args.nums, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,1,1], k = 2",
                        new Args(new int[]{1, 1, 1}, 2),
                        new Expectations(2)),
                Arguments.of(
                        "case: nums = [1,2,3], k = 3",
                        new Args(new int[]{1, 2, 3}, 3),
                        new Expectations(2)),
                Arguments.of(
                        "case: nums = [1], k = 0",
                        new Args(new int[]{1}, 0),
                        new Expectations(0)),
                Arguments.of(
                        "case: nums = [0], k = 0",
                        new Args(new int[]{0}, 0),
                        new Expectations(1)),
                Arguments.of(
                        "case: nums = [-1,-1,1], k = 0",
                        new Args(new int[]{-1, -1, 1}, 0),
                        new Expectations(1)));
    }

    record Args(int[] nums, int k) {
    }

    record Expectations(int want) {
    }
}