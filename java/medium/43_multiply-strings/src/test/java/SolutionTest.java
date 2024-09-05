import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 27/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void multiply(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().multiply(args.num1, args.num2));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: num1 = \"2\", num2 = \"3\"",
                        new Args("2", "3"),
                        new Expectations("6")),
                Arguments.of(
                        "case: num1 = \"123\", num2 = \"456\"",
                        new Args("123", "456"),
                        new Expectations("56088")),
                Arguments.of(
                        "case: num1 = \"12\", num2 = \"34\"",
                        new Args("12", "34"),
                        new Expectations("408")),
                Arguments.of(
                        "case: num1 = \"0\", num2 = \"0\"",
                        new Args("0", "0"),
                        new Expectations("0")),
                Arguments.of(
                        "case: num1 = \"99\", num2 = \"99\"",
                        new Args("99", "99"),
                        new Expectations("9801")));
    }

    record Args(String num1, String num2) {
    }

    record Expectations(String want) {
    }
}