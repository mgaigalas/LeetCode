import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 10/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void plusOne(String name, Args args, int[] want) {
        Assertions.assertArrayEquals(want, new Solution().plusOne(args.digits));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: digits = [1,2,3]",
                        new Args(new int[]{1, 2, 3}),
                        new int[]{1, 2, 4}),
                Arguments.of(
                        "case: digits = [4,3,2,1]",
                        new Args(new int[]{4, 3, 2, 1}),
                        new int[]{4, 3, 2, 2}),
                Arguments.of(
                        "case: digits = [9]",
                        new Args(new int[]{9}),
                        new int[]{1, 0}));
    }

    record Args(int[] digits) {
    }
}