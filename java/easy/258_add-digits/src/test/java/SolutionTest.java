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
    void addDigits(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().addDigits(args.num));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: num = 38",
                        new Args(38),
                        new Expectations(2)),
                Arguments.of(
                        "case: num = 0",
                        new Args(0),
                        new Expectations(0)));
    }

    record Args(int num) {
    }

    record Expectations(int want) {
    }
}