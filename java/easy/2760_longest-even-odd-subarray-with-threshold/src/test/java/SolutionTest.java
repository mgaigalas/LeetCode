import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 20/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void longestAlternatingSubarray(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().longestAlternatingSubarray(args.nums, args.threshold));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [3,2,5,4], threshold = 5",
                        new Args(new int[]{3, 2, 5, 4}, 5),
                        new Expectations(3)),
                Arguments.of(
                        "case: nums = [1,2], threshold = 2",
                        new Args(new int[]{1, 2}, 2),
                        new Expectations(1)),
                Arguments.of(
                        "case: nums = [2,3,4,5], threshold = 4",
                        new Args(new int[]{2, 3, 4, 5}, 4),
                        new Expectations(3)),
                Arguments.of(
                        "case: nums = [2], threshold = 2",
                        new Args(new int[]{2}, 2),
                        new Expectations(1)));
    }

    record Args(int[] nums, int threshold) {
    }

    record Expectations(int want) {
    }
}