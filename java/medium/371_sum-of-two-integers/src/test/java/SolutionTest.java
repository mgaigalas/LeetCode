import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 10/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void getSum(String name, Args args, int want) {
        Assertions.assertEquals(want, new Solution().getSum(args.a, args.b));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: a = 1, b = 2",
                        new Args(1, 2),
                        3),
                Arguments.of(
                        "case: a = 2, b = 3",
                        new Args(2, 3),
                        5),
                Arguments.of(
                        "case: a = -1, b = 1",
                        new Args(-1, 1),
                        0),
                Arguments.of(
                        "case: a = -12, b = -8",
                        new Args(-12, -8),
                        -20));
    }

    record Args(int a, int b) {
    }
}