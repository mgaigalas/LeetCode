import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 15/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void fizzBuzz(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().fizzBuzz(args.n));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: n = 3",
                        new Args(3),
                        new Expectations(List.of(
                                "1",
                                "2",
                                "Fizz"))),
                Arguments.of(
                        "case: n = 5",
                        new Args(5),
                        new Expectations(List.of(
                                "1",
                                "2",
                                "Fizz",
                                "4",
                                "Buzz"))),
                Arguments.of(
                        "case: n = 15",
                        new Args(15),
                        new Expectations(List.of(
                                "1",
                                "2",
                                "Fizz",
                                "4",
                                "Buzz",
                                "Fizz",
                                "7",
                                "8",
                                "Fizz",
                                "Buzz",
                                "11",
                                "Fizz",
                                "13",
                                "14",
                                "FizzBuzz"))));
    }

    record Args(int n) {
    }

    record Expectations(List<String> want) {
    }
}