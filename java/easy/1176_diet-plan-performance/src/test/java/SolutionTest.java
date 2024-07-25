import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 25/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void dietPlanPerformance(String name, Args args, Expectations want) {
        Assertions.assertEquals(
                want.want,
                new Solution().dietPlanPerformance(
                        args.calories,
                        args.k,
                        args.lower,
                        args.upper));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3",
                        new Args(new int[]{1, 2, 3, 4, 5}, 1, 3, 3),
                        new Expectations(0)),
                Arguments.of(
                        "case: calories = [3,2], k = 2, lower = 0, upper = 1",
                        new Args(new int[]{3, 2}, 2, 0, 1),
                        new Expectations(1)),
                Arguments.of(
                        "case: calories = [6,5,0,0], k = 2, lower = 1, upper = 5",
                        new Args(new int[]{6, 5, 0, 0}, 2, 1, 5),
                        new Expectations(0)));
    }

    record Args(int[] calories, int k, int lower, int upper) {
    }

    record Expectations(int want) {
    }
}