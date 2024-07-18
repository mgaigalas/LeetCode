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
    void minLength(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().minLength(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"ABFCACDB\"",
                        new Args("ABFCACDB"),
                        new Expectations(2)),
                Arguments.of(
                        "case: s = \"ACBBD\"",
                        new Args("ACBBD"),
                        new Expectations(5)));
    }

    record Args(String s) {
    }

    record Expectations(int want) {
    }
}