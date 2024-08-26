import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 26/08/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void canVisitAllRooms(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().canVisitAllRooms(args.rooms));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: rooms = [[1],[2],[3],[]]",
                        new Args(List.of(
                                List.of(1),
                                List.of(2),
                                List.of(3),
                                List.of())),
                        new Expectations(true)),
                Arguments.of(
                        "case: rooms = [[1,3],[3,0,1],[2],[0]]",
                        new Args(List.of(
                                List.of(1, 3),
                                List.of(3, 0, 1),
                                List.of(2),
                                List.of(0))),
                        new Expectations(false)),
                Arguments.of(
                        "case: rooms = [1],[2],[],[3]]",
                        new Args(List.of(
                                List.of(1),
                                List.of(2),
                                List.of(),
                                List.of(3))),
                        new Expectations(false)));
    }

    record Args(List<List<Integer>> rooms) {
    }

    record Expectations(boolean want) {
    }
}