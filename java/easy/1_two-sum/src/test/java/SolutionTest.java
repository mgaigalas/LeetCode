import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 04/06/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void twoSum(String name, Args args, int[] want) {
        Assertions.assertArrayEquals(want, new Solution().twoSum(args.nums, args.target));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [2,7,11,15], target = 9",
                        new Args(new int[]{2, 7, 11, 15}, 9),
                        new int[]{0, 1}),
                Arguments.of(
                        "case: nums = [3,2,4], target = 6",
                        new Args(new int[]{3, 2, 4}, 6),
                        new int[]{1, 2}),
                Arguments.of(
                        "case: nums = [3,3], target = 6",
                        new Args(new int[]{3, 3}, 6),
                        new int[]{0, 1}));
    }

    record Args(int[] nums, int target) {
    }
}