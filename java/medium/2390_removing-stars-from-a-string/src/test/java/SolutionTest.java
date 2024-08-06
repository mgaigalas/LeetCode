import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 06/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void removeStars(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().removeStars(args.s));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: s = \"leet**cod*e\"",
                        new Args("leet**cod*e"),
                        new Expectations("lecoe")),
                Arguments.of(
                        "case: s = \"erase*****\"",
                        new Args("erase*****"),
                        new Expectations("")));
    }

    record Args(String s) {
    }

    record Expectations(String want) {
    }
}