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
    void lengthOfLongestSubstring(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().lengthOfLongestSubstring(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"abcabcbb\"",
                        new Args("abcabcbb"),
                        new Expectations(3)),
                Arguments.of(
                        "case: s = \"bbbbb\"",
                        new Args("bbbbb"),
                        new Expectations(1)),
                Arguments.of(
                        "case: s = \"pwwkew\"",
                        new Args("pwwkew"),
                        new Expectations(3)));
    }

    record Args(String s) {
    }

    record Expectations(int want) {
    }
}