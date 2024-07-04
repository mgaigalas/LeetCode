import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 04/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void isValid(String name, Args args, boolean want) {
        Assertions.assertEquals(want, new Solution().isValid(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"()\"",
                        new Args("()"),
                        true),
                Arguments.of(
                        "case: s = \"()[]{}\"",
                        new Args("()[]{}"),
                        true),
                Arguments.of(
                        "case: s = \"(]\"",
                        new Args("(]"),
                        false),
                Arguments.of(
                        "case: s = \"]\"",
                        new Args("]"),
                        false),
                Arguments.of(
                        "case: s = \"){\"",
                        new Args("){"),
                        false));
    }

    record Args(String s) {
    }
}