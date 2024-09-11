import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 11/09/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void topKFrequent(String name, Args args, Expectations want) {
        Assertions.assertArrayEquals(want.want, new Solution().topKFrequent(args.nums, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,1,1,2,2,3], k = 2",
                        new Args(new int[]{1, 1, 1, 2, 2, 3}, 2),
                        new Expectations(new int[]{1, 2})),
                Arguments.of(
                        "case: nums = [1], k = 1",
                        new Args(new int[]{1}, 1),
                        new Expectations(new int[]{1})));
    }

    record Args(int[] nums, int k) {
    }

    record Expectations(int[] want) {
    }
}