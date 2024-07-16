import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 13/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void isSymmetric(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.pick, new Solution(want.pick).guessNumber(args.n));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: n = 10, pick = 6",
                        new Args(10),
                        new Expectations(6)),
                Arguments.of(
                        "case: n = 1, pick = 1",
                        new Args(1),
                        new Expectations(1)),
                Arguments.of(
                        "case: n = 2, pick = 1",
                        new Args(2),
                        new Expectations(1)));
    }

    @Test
    void guessNumber() {
    }

    record Args(int n) {
    }

    record Expectations(int pick) {
    }
}