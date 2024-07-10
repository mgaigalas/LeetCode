import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 10/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void addToArrayForm(String name, Args args, List<Integer> want) {
        Assertions.assertIterableEquals(want, new Solution().addToArrayForm(args.num, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: num = [1,2,0,0], k = 34",
                        new Args(new int[]{1, 2, 0, 0}, 34),
                        List.of(1, 2, 3, 4)),
                Arguments.of(
                        "case: num = [2,7,4], k = 181",
                        new Args(new int[]{2, 7, 4}, 181),
                        List.of(4, 5, 5)),
                Arguments.of(
                        "case: num = [2,1,5], k = 806",
                        new Args(new int[]{2, 1, 5}, 806),
                        List.of(1, 0, 2, 1)));
    }

    record Args(int[] num, int k) {
    }
}