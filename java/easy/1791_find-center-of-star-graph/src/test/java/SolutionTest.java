import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 21/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void findCenter(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().findCenter(args.edges));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: edges = [[1,2],[2,3],[4,2]]",
                        new Args(new int[][]{{1, 2}, {2, 3}, {4, 2}}),
                        new Expectations(2)),
                Arguments.of(
                        "case: edges = [[1,2],[5,1],[1,3],[1,4]]",
                        new Args(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}),
                        new Expectations(1)));
    }

    record Args(int[][] edges) {
    }

    record Expectations(int want) {
    }
}