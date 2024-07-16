import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 16/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void isUgly(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.ugly, new Solution().isUgly(args.n));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: n = 6",
                        new Args(6),
                        new Expectations(true)),
                Arguments.of(
                        "case: n = 1",
                        new Args(1),
                        new Expectations(true)),
                Arguments.of(
                        "case: n = 0",
                        new Args(0),
                        new Expectations(false)),
                Arguments.of(
                        "case: n = 14",
                        new Args(14),
                        new Expectations(false)),
                Arguments.of(
                        "case: n = -14",
                        new Args(-14),
                        new Expectations(false)),
                Arguments.of(
                        "case: n = -6",
                        new Args(-6),
                        new Expectations(false)));
    }

    record Args(int n) {
    }

    record Expectations(boolean ugly) {
    }
}