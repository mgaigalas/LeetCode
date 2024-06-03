import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 29/05/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void sortColors(String name, Args args, int[] want) {
        final var nums = args.nums;
        new Solution().sortColors(nums);
        Assertions.assertArrayEquals(want, nums);
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [2,0,2,1,1,0]",
                        new Args(new int[]{2, 0, 2, 1, 1, 0}),
                        new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.of(
                        "case: nums = [2,0,1]",
                        new Args(new int[]{2, 0, 1}),
                        new int[]{0, 1, 2}));
    }

    record Args(int[] nums) {
    }
}