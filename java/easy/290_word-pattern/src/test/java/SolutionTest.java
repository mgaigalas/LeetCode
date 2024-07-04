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
    void wordPattern(String name, Args args, boolean want) {
        Assertions.assertEquals(want, new Solution().wordPattern(args.pattern, args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: pattern = \"abba\", s = \"dog cat cat dog\"",
                        new Args("abba", "dog cat cat dog"),
                        true),
                Arguments.of(
                        "case: pattern = \"abba\", s = \"dog cat cat fish\"",
                        new Args("abba", "dog cat cat fish"),
                        false),
                Arguments.of(
                        "case: pattern = \"aaaa\", s = \"dog cat cat dog\"",
                        new Args("aaaa", "dog cat cat dog"),
                        false),
                Arguments.of(
                        "case: pattern = \"abba\", s = \"dog dog dog dog\"",
                        new Args("abba", "dog dog dog dog"),
                        false));
    }

    record Args(String pattern, String s) {
    }
}