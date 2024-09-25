import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 25/09/2024
 */
class SolutionTest {
    private static final Solution objectUnderTest = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void encodeAndDecode(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, objectUnderTest.decode(objectUnderTest.encode(args.strings)));
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: dummy_input = [\"Hello\",\"World\"]",
                        new Args(List.of("Hello", "World")),
                        new Expectations(List.of("Hello", "World"))),
                Arguments.of(
                        "case: dummy_input = [\"\"]",
                        new Args(List.of("")),
                        new Expectations(List.of(""))),
                Arguments.of(
                        "case: dummy_input = [\"a\"]",
                        new Args(List.of("a")),
                        new Expectations(List.of("a"))),
                Arguments.of(
                        "case: dummy_input = [\"\",\"\"]",
                        new Args(List.of("", "")),
                        new Expectations(List.of("", ""))));
    }

    record Args(List<String> strings) {
    }

    record Expectations(List<String> want) {
    }
}