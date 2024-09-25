import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 25/09/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void productExceptSelf(String name, Args args, Expectations want) {
        Assertions.assertArrayEquals(want.want, new Solution().productExceptSelf(args.nums));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,2,3,4]",
                        new Args(new int[]{1, 2, 3, 4}),
                        new Expectations(new int[]{24, 12, 8, 6})),
                Arguments.of(
                        "case: nums = [-1,1,0,-3,3]",
                        new Args(new int[]{-1, 1, 0, -3, 3}),
                        new Expectations(new int[]{0, 0, 9, 0, 0})),
                Arguments.of(
                        "case: nums = [4,5,1,8,2]",
                        new Args(new int[]{4, 5, 1, 8, 2}),
                        new Expectations(new int[]{80, 64, 320, 40, 160})));
    }

    record Args(int[] nums) {
    }

    record Expectations(int[] want) {
    }
}