import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 24/07/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void getAverages(String name, Args args, Expectations want) {
        Assertions.assertArrayEquals(want.want, new Solution().getAverages(args.nums, args.k));
    }

    static Stream<Arguments> argumentSource() throws IOException {
        final var ec = new ObjectMapper().readValue(
                SolutionTest.class.getResourceAsStream("/case-01.json"),
                ExternalCase.class);

        return Stream.of(
                Arguments.of(
                        "case: nums = [7,4,3,9,1,8,5,2,6], k = 3",
                        new Args(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3),
                        new Expectations(new int[]{-1, -1, -1, 5, 4, 4, -1, -1, -1})),
                Arguments.of(
                        "case: nums = [7,4,3,9,1,8,5,2,6], k = 3",
                        new Args(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3),
                        new Expectations(new int[]{-1, -1, -1, 5, 4, 4, -1, -1, -1})),
                Arguments.of(
                        "case: nums = [100000], k = 0",
                        new Args(new int[]{100000}, 0),
                        new Expectations(new int[]{100000})),
                Arguments.of(
                        "case: nums = [8], k = 100000",
                        new Args(new int[]{8}, 100000),
                        new Expectations(new int[]{-1})),
                Arguments.of(
                        ec.name,
                        ec.args,
                        ec.expectations));
    }

    record ExternalCase(String name, Args args, Expectations expectations) {
    }

    record Args(int[] nums, int k) {
    }

    record Expectations(int[] want) {
    }
}