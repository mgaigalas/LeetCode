import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 29/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void countGoodSubstrings(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().countGoodSubstrings(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"xyzzaz\"",
                        new Args("xyzzaz"),
                        new Expectations(1)),
                Arguments.of(
                        "case: s = \"aababcabc\"",
                        new Args("aababcabc"),
                        new Expectations(4)),
                Arguments.of(
                        "case: s = \"owuxoelszb\"",
                        new Args("owuxoelszb"),
                        new Expectations(8)));
    }

    record Args(String s) {
    }

    record Expectations(int want) {
    }
}