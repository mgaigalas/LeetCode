import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 12/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void maximumLengthSubstring(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().maximumLengthSubstring(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "s = \"bcbbbcba\"",
                        new Args("bcbbbcba"),
                        new Expectations(4)),
                Arguments.of(
                        "s = \"aaaa\"",
                        new Args("aaaa"),
                        new Expectations(2)));
    }

    record Args(String s) {
    }

    record Expectations(int want) {
    }
}