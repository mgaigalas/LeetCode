import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 19/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void divisorSubstrings(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().divisorSubstrings(args.num, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: num = 240, k = 2",
                        new Args(240, 2),
                        new Expectations(2)),
                Arguments.of(
                        "case: num = 430043, k = 2",
                        new Args(430043, 2),
                        new Expectations(2)));
    }

    record Args(int num, int k) {
    }

    record Expectations(int want) {
    }
}