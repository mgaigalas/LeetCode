import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 23/05/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void heightChecker(String name, Args args, int want) {
        Assertions.assertEquals(want, new Solution().heightChecker(args.heights));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: heights = [1,1,4,2,1,3]",
                        new Args(new int[]{1,1,4,2,1,3}),
                        3),
                Arguments.of(
                        "case: heights = [5,1,2,3,4]",
                        new Args(new int[]{5,1,2,3,4}),
                        5),
                Arguments.of(
                        "case: heights = [1,2,3,4,5]",
                        new Args(new int[]{1,2,3,4,5}),
                        0));
    }

    record Args(int[] heights) {
    }
}