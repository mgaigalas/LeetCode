import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 24/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void containsNearbyDuplicate(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().containsNearbyDuplicate(args.nums, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,2,3,1], k = 3",
                        new Args(new int[]{1, 2, 3, 1}, 3),
                        new Expectations(true)),
                Arguments.of(
                        "case: nums = [1,0,1,1], k = 1",
                        new Args(new int[]{1, 0, 1, 1}, 1),
                        new Expectations(true)),
                Arguments.of(
                        "case: nums = [1,2,3,1,2,3], k = 2",
                        new Args(new int[]{1, 2, 3, 1, 2, 3}, 2),
                        new Expectations(false)));
    }

    record Args(int[] nums, int k) {
    }

    record Expectations(boolean want) {
    }
}