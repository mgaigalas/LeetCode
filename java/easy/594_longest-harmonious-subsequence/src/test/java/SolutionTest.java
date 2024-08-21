import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 21/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void findLHS(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().findLHS(args.nums));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,3,2,2,5,2,3,7]",
                        new Args(new int[]{1, 3, 2, 2, 5, 2, 3, 7}),
                        new Expectations(5)),
                Arguments.of(
                        "case: nums = [1,2,3,4]",
                        new Args(new int[]{1, 2, 3, 4}),
                        new Expectations(2)),
                Arguments.of(
                        "case: nums = [1,1,1,1]",
                        new Args(new int[]{1, 1, 1, 1}),
                        new Expectations(0)),
                Arguments.of(
                        "case: nums = [1,2,2,1]",
                        new Args(new int[]{1, 2, 2, 1}),
                        new Expectations(4)));
    }

    record Args(int[] nums) {
    }

    record Expectations(int want) {
    }
}