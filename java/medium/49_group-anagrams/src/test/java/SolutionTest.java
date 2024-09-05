import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 05/09/2024
 */
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void groupAnagrams(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().groupAnagrams(args.strs));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: strs = [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]",
                        new Args(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}),
                        new Expectations(List.of(
                                List.of("bat"),
                                List.of("tan", "nat"),
                                List.of("eat", "tea", "ate")))),
                Arguments.of(
                        "case: strs = [\"\"]",
                        new Args(new String[]{""}),
                        new Expectations(List.of(List.of("")))),
                Arguments.of(
                        "case: strs = [\"a\"]",
                        new Args(new String[]{"a"}),
                        new Expectations(List.of(List.of("a")))));
    }

    record Args(String[] strs) {
    }

    record Expectations(List<List<String>> want) {
    }
}