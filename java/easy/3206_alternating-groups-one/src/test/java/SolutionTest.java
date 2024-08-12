import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 12/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void numberOfAlternatingGroups(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().numberOfAlternatingGroups(args.colors));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "colors = [1,1,1]",
                        new Args(new int[]{1, 1, 1}),
                        new Expectations(0)),
                Arguments.of(
                        "colors = [0,1,0,0,1]",
                        new Args(new int[]{0, 1, 0, 0, 1}),
                        new Expectations(3)));
    }

    record Args(int[] colors) {
    }

    record Expectations(int want) {
    }
}