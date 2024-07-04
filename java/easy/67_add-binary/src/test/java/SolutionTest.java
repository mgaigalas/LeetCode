import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 03/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void addBinary(String name, Args args, String want) {
        Assertions.assertEquals(want, new Solution().addBinary(args.a, args.b));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: a = \"11\", b = \"1\"",
                        new Args("11", "1"),
                        "100"),
                Arguments.of(
                        "a = \"1010\", b = \"1011\"",
                        new Args("1010", "1011"),
                        "10101"));
    }

    record Args(String a, String b) {
    }
}