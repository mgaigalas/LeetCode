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
    void minimumRecolors(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().minimumRecolors(args.blocks, args.k));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: blocks = \"WBBWWBBWBW\", k = 7",
                        new Args("WBBWWBBWBW", 7),
                        new Expectations(3)),
                Arguments.of(
                        "case: blocks = \"WBWBBBW\", k = 2",
                        new Args("WBWBBBW", 2),
                        new Expectations(0)),
                Arguments.of(
                        "case: blocks = \"BWWWBB\", k = 6",
                        new Args("BWWWBB", 6),
                        new Expectations(3)),
                Arguments.of(
                        "case: blocks = \"WWBBBWBBBBBWWBWWWB\", k = 16",
                        new Args("WWBBBWBBBBBWWBWWWB", 16),
                        new Expectations(6)),
                Arguments.of(
                        "case: blocks = \"BWBBWWBBBWBWWWBWWBBWBWBBWBB\", k = 11",
                        new Args("BWBBWWBBBWBWWWBWWBBWBWBBWBB", 11),
                        new Expectations(4)));
    }

    record Args(String blocks, int k) {
    }

    record Expectations(int want) {
    }
}