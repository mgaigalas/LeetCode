import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 18/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void climbStairs(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().climbStairs(args.n));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: n = 2",
                        new Args(2),
                        new Expectations(2)),
                Arguments.of(
                        "case: n = 3",
                        new Args(3),
                        new Expectations(3)),
                Arguments.of(
                        "case: n = 4",
                        new Args(4),
                        new Expectations(5)));
    }

    record Args(int n) {
    }

    record Expectations(int want) {
    }
}