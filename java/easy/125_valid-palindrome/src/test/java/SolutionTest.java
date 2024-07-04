import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 02/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void isPalindrome(String name, Args args, boolean want) {
        Assertions.assertEquals(want, new Solution().isPalindrome(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"A man, a plan, a canal: Panama\"",
                        new Args("A man, a plan, a canal: Panama"),
                        true),
                Arguments.of(
                        "case: s = \"race a car\"",
                        new Args("race a car"),
                        false),
                Arguments.of(
                        "case: s = \" \"",
                        new Args(" "),
                        true));
    }

    record Args(String s) {
    }
}