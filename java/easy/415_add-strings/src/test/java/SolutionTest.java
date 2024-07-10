import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 09/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void addStrings(String name, Args args, String want) {
        Assertions.assertEquals(want, new Solution().addStrings(args.num1, args.num2));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: num1 = \"11\", num2 = \"123\"",
                        new Args("11", "123"),
                        "134"),
                Arguments.of(
                        "case: num1 = \"456\", num2 = \"77\"",
                        new Args("456", "77"),
                        "533"),
                Arguments.of(
                        "case: num1 = \"0\", num2 = \"0\"",
                        new Args("0", "0"),
                        "0"));
    }

    record Args(String num1, String num2) {
    }
}