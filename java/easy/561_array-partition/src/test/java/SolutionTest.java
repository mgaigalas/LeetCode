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
    void arrayPairSum(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().arrayPairSum(args.nums));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,4,3,2]",
                        new Args(new int[]{1, 4, 3, 2}),
                        new Expectations(4)),
                Arguments.of(
                        "case: nums = [6,2,6,5,1,2]",
                        new Args(new int[]{6, 2, 6, 5, 1, 2}),
                        new Expectations(9)));
    }

    record Args(int[] nums) {
    }

    record Expectations(int want) {
    }
}