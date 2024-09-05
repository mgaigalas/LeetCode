import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 04/09/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void isAnagram(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().isAnagram(args.s, args.t));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"anagram\", t = \"nagaram\"",
                        new Args("anagram", "nagaram"),
                        new Expectations(true)),
                Arguments.of(
                        "case: s = \"rat\", t = \"car\"",
                        new Args("rat", "car"),
                        new Expectations(false)),
                Arguments.of(
                        "case: s = \"ab\", t = \"a\"",
                        new Args("ab", "a"),
                        new Expectations(false)));
    }

    record Args(String s, String t) {
    }

    record Expectations(boolean want) {
    }
}