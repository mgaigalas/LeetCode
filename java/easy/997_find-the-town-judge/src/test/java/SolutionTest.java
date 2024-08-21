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
    void findJudge(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().findJudge(args.n, args.trust));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: n = 2, trust = [[1,2]]",
                        new Args(2, new int[][]{{1, 2}}),
                        new Expectations(2)),
                Arguments.of(
                        "case: n = 3, trust = [[1,3],[2,3]]",
                        new Args(3, new int[][]{{1, 3}, {2, 3}}),
                        new Expectations(3)),
                Arguments.of(
                        "case: n = 3, trust = [[1,3],[2,3],[3,1]]",
                        new Args(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}),
                        new Expectations(-1)),

                Arguments.of(
                        "case: n = 1, trust = []",
                        new Args(1, new int[][]{}),
                        new Expectations(1)),
                Arguments.of(
                        "case: n = 2, trust = [[2,1]]",
                        new Args(2, new int[][]{{2, 1}}),
                        new Expectations(1)),
                Arguments.of(
                        "case: n = 3, trust = [[1,2],[1,3],[2,1],[2,3],[3,2]]",
                        new Args(3, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {3, 2}}),
                        new Expectations(-1)),
                Arguments.of(
                        "case: n = 4, trust = [[2,1],[3,1],[4,1],[3,2]]",
                        new Args(4, new int[][]{{2, 1}, {3, 1}, {4, 1}, {3, 2}}),
                        new Expectations(1)),
                Arguments.of(
                        "case: n = 5, trust = [[1,3],[1,4],[1,5],[2,5],[3,2],[4,1],[4,2],[4,3],[4,5],[5,1],[5,2],[5,4]]",
                        new Args(5, new int[][]{{1, 3}, {1, 4}, {1, 5}, {2, 5}, {3, 2}, {4, 1}, {4, 2}, {4, 3},
                                {4, 5}, {5, 1}, {5, 2}, {5, 4}}),
                        new Expectations(-1)));
    }

    record Args(int n, int[][] trust) {
    }

    record Expectations(int want) {
    }
}