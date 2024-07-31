import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 31/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void addDigits(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().numOfSubarrays(
                args.arr,
                args.k,
                args.threshold));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4",
                        new Args(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4),
                        new Expectations(3)),
                Arguments.of(
                        "case: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5",
                        new Args(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5),
                        new Expectations(6)));
    }

    record Args(int[] arr, int k, int threshold) {
    }

    record Expectations(int want) {
    }
}