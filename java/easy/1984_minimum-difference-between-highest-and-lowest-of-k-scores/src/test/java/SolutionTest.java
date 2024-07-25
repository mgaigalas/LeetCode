import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 25/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void minimumDifference(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().minimumDifference(args.nums, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [90], k = 1",
                        new Args(new int[]{90}, 1),
                        new Expectations(0)),
                Arguments.of(
                        "case: nums = [9,4,1,7], k = 2",
                        new Args(new int[]{9, 4, 1, 7}, 2),
                        new Expectations(2)));
    }

    record Args(int[] nums, int k) {
    }

    record Expectations(int want) {
    }
}