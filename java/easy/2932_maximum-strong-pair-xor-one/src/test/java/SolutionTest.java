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
    void maximumStrongPairXor(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().maximumStrongPairXor(args.nums));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,2,3,4,5]",
                        new Args(new int[]{1, 2, 3, 4, 5}),
                        new Expectations(7)),
                Arguments.of(
                        "case: nums = [10,100]",
                        new Args(new int[]{10, 100}),
                        new Expectations(0)),
                Arguments.of(
                        "case: nums = [5,6,25,30]",
                        new Args(new int[]{5, 6, 25, 30}),
                        new Expectations(7)));
    }

    record Args(int[] nums) {
    }

    record Expectations(int want) {
    }
}