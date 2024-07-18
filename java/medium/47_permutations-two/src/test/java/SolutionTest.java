import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 18/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void permuteUnique(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().permuteUnique(args.nums));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,1,2]",
                        new Args(new int[]{1, 1, 2}),
                        new Expectations(List.of(
                                List.of(1, 1, 2),
                                List.of(1, 2, 1),
                                List.of(2, 1, 1)))),
                Arguments.of(
                        "case: nums = [1,2,3]",
                        new Args(new int[]{1, 2, 3}),
                        new Expectations(List.of(
                                List.of(1, 2, 3),
                                List.of(1, 3, 2),
                                List.of(2, 1, 3),
                                List.of(2, 3, 1),
                                List.of(3, 1, 2),
                                List.of(3, 2, 1)))));
    }

    record Args(int[] nums) {
    }

    record Expectations(List<List<Integer>> want) {
    }
}