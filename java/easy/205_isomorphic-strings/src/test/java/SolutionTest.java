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
    void isIsomorphic(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.flag, new Solution().isIsomorphic(args.s, args.t));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"egg\", t = \"add\"",
                        new Args("egg", "add"),
                        new Expectations(true)),
                Arguments.of(
                        "case: s = \"foo\", t = \"bar\"",
                        new Args("foo", "bar"),
                        new Expectations(false)),
                Arguments.of(
                        "case: s = \"paper\", t = \"title\"",
                        new Args("paper", "title"),
                        new Expectations(true)),
                Arguments.of(
                        "case: s = \"badc\", t = \"baba\"",
                        new Args("badc", "baba"),
                        new Expectations(false)));
    }

    record Args(String s, String t) {
    }

    record Expectations(boolean flag) {
    }
}