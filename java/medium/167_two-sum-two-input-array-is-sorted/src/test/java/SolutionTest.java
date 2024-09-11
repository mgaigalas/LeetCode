import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 06/09/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void twoSum(String name, Args args, Expectations want) {
        Assertions.assertArrayEquals(want.want, new Solution().twoSum(args.numbers, args.target));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: numbers = [2,7,11,15], target = 9",
                        new Args(new int[]{2, 7, 11, 15}, 9),
                        new Expectations(new int[]{1, 2})),
                Arguments.of(
                        "case: numbers = [2,3,4], target = 6",
                        new Args(new int[]{2, 3, 4}, 6),
                        new Expectations(new int[]{1, 3})),
                Arguments.of(
                        "case: numbers = [-1,0], target = -1",
                        new Args(new int[]{-1, 0}, -1),
                        new Expectations(new int[]{1, 2})),
                Arguments.of(
                        "case: numbers = [5,25,75], target = 100",
                        new Args(new int[]{5, 25, 75}, 100),
                        new Expectations(new int[]{2, 3})),
                Arguments.of(
                        "case: numbers = [3,24,50,79,88,150,345], target = 200",
                        new Args(new int[]{3, 24, 50, 79, 88, 150, 345}, 200),
                        new Expectations(new int[]{3, 6})));
    }

    record Args(int[] numbers, int target) {
    }

    record Expectations(int[] want) {
    }
}