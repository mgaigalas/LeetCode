import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 02/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void nextGreaterElement(String name, Args args, Expectations want) {
        Assertions.assertArrayEquals(want.want, new Solution().nextGreaterElement(args.nums1, args.nums2));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums1 = [4,1,2], nums2 = [1,3,4,2]",
                        new Args(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}),
                        new Expectations(new int[]{-1, 3, -1})),
                Arguments.of(
                        "case: nums1 = [2,4], nums2 = [1,2,3,4]",
                        new Args(new int[]{2, 4}, new int[]{1, 2, 3, 4}),
                        new Expectations(new int[]{3, -1})));
    }

    record Args(int[] nums1, int[] nums2) {
    }

    record Expectations(int[] want) {
    }
}