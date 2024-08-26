import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 23/08/2024
 */
class SolutionTest {
    private static final ObjectMapper mapper = new ObjectMapper();

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void validPath(String name, Args args, Expectations want) {
        Assertions.assertEquals(want.want, new Solution().validPath(
                args.n,
                args.edges,
                args.source,
                args.destination));
    }

    static Stream<Arguments> argumentSource() throws IOException, URISyntaxException {
        final List<Arguments> staticArguments = List.of(
                Arguments.of(
                        "case: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2",
                        new Args(
                                3,
                                new int[][]{{0, 1}, {1, 2}, {2, 0}},
                                0,
                                2
                        ),
                        new Expectations(true)),
                Arguments.of(
                        "case: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5",
                        new Args(
                                6,
                                new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}},
                                0,
                                5
                        ),
                        new Expectations(false)),
                Arguments.of(
                        "case: n = 1, edges = [], source = 0, destination = 0",
                        new Args(
                                1,
                                new int[][]{},
                                0,
                                0
                        ),
                        new Expectations(true)),
                Arguments.of(
                        "case: n = 2, edges = [], source = 0, destination = 1",
                        new Args(
                                1,
                                new int[][]{},
                                0,
                                0
                        ),
                        new Expectations(true)));

        final var resource = SolutionTest.class.getClassLoader().getResource("external-cases");
        final var externalCasesPath = Paths.get(Objects.requireNonNull(resource).toURI());
        try (Stream<Path> stream = Files.walk(externalCasesPath)) {
            final var externalArguments = stream
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .map(SolutionTest::loadExternalCase)
                    .map(ec -> Arguments.of(
                            ec.name,
                            ec.args,
                            ec.expectations))
                    .toList();
            final List<Arguments> arguments = new ArrayList<>(staticArguments);
            arguments.addAll(externalArguments);
            return arguments.stream();
        }
    }

    record ExternalCase(String name, Args args, Expectations expectations) {
    }

    record Args(int n, int[][] edges, int source, int destination) {
    }

    record Expectations(boolean want) {
    }

    private static ExternalCase loadExternalCase(File path) {
        try {
            return mapper.readValue(
                    path,
                    ExternalCase.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}