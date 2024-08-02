import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 02/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void finalPrices(String name, Args args, Expectations want) {
        Assertions.assertArrayEquals(want.want, new Solution().finalPrices(args.prices));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: prices = [8,4,6,2,3]",
                        new Args(new int[]{8, 4, 6, 2, 3}),
                        new Expectations(new int[]{4, 2, 4, 2, 3})),
                Arguments.of(
                        "case: prices = [1,2,3,4,5]",
                        new Args(new int[]{1, 2, 3, 4, 5}),
                        new Expectations(new int[]{1, 2, 3, 4, 5})),
                Arguments.of(
                        "case: prices = [10,1,1,6]",
                        new Args(new int[]{10, 1, 1, 6}),
                        new Expectations(new int[]{9, 0, 1, 6})));
    }

    record Args(int[] prices) {
    }

    record Expectations(int[] want) {
    }
}