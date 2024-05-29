import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 23/05/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void numIdenticalPairs(String name, int[] args, int want) {
        Assertions.assertEquals(want, new Solution().numIdenticalPairs(args));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: nums = [1,2,3,1,1,3]",
                        new int[]{1, 2, 3, 1, 1, 3},
                        4),
                Arguments.of(
                        "case: nums = [1,1,1,1]",
                        new int[]{1, 1, 1, 1},
                        6));
    }
}