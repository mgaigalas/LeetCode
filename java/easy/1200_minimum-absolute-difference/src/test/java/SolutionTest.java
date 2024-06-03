import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 02/06/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void minimumAbsDifference(String name, Args args, List<List<Integer>> want) {
        Assertions.assertEquals(want, new Solution().minimumAbsDifference(args.arr));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: arr = [4,2,1,3]",
                        new Args(new int[]{4, 2, 1, 3}),
                        List.of(
                                List.of(1, 2),
                                List.of(2, 3),
                                List.of(3, 4))),
                Arguments.of(
                        "case: arr = [1,3,6,10,15]",
                        new Args(new int[]{1, 3, 6, 10, 15}),
                        List.of(List.of(1, 3))),
                Arguments.of(
                        "case: arr = [3,8,-10,23,19,-4,-14,27]",
                        new Args(new int[]{3, 8, -10, 23, 19, -4, -14, 27}),
                        List.of(
                                List.of(-14, -10),
                                List.of(19, 23),
                                List.of(23, 27))));
    }

    record Args(int[] arr) {
    }
}