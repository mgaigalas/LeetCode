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
    void twoSum(String name, Args args, Expectations want) {
        var nums = args.nums;
        var k = new Solution().removeDuplicates(nums);
        for (int i = 0; i < want.nums.length; i++) {
            Assertions.assertEquals(want.nums[i], nums[i]);
        }
        Assertions.assertEquals(want.k, k);
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,1,2]",
                        new Args(new int[]{1, 1, 2}),
                        new Expectations(2, new int[]{1, 2})),
                Arguments.of(
                        "case: nums = [0,0,1,1,1,2,2,3,3,4]",
                        new Args(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}),
                        new Expectations(5, new int[]{0, 1, 2, 3, 4})));
    }

    record Args(int[] nums) {
    }

    record Expectations(int k, int[] nums) {
    }
}