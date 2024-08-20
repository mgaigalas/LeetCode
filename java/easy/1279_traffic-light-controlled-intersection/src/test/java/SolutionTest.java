import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * @author Marius Gaigalas on 16/08/2024
 */
@Slf4j
class SolutionTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentSource")
    void carArrived(String name, Args args, Expectations want) throws InterruptedException {
        final List<TestExecutionArg> executionArgs = new ArrayList<>();
        final var it = args.args().iterator();
        var prevArg = it.next();
        executionArgs.add(toTestExecutionArg(prevArg, toRoadId(prevArg.direction()) != 1));
        while (it.hasNext()) {
            var arg = it.next();
            executionArgs.add(toTestExecutionArg(
                    arg,
                    toRoadId(arg.direction()) != toRoadId(prevArg.direction())));
            prevArg = arg;
        }

        final var numberOfTests = args.args.size();
        final var objectUnderTest = new Solution();

        final List<String> stateRecords = Collections.synchronizedList(new ArrayList<>(numberOfTests));
        final CountDownLatch latch = new CountDownLatch(numberOfTests);
        try (ExecutorService executorService = Executors.newFixedThreadPool(numberOfTests)) {
            for (int i = 0; i < executionArgs.size(); i++) {
                executorService.submit(new InternalTestRunnable(executionArgs.get(i), args.args().get(i).arrivalTime()) {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(this.delayInMillis);
                            objectUnderTest.carArrived(
                                    this.executionArg.carId(),
                                    this.executionArg.roadId(),
                                    this.executionArg.direction(),
                                    new TestCaseActionRunnable(
                                            TestCaseActionType.TURN_GREEN,
                                            this.executionArg,
                                            stateRecords),
                                    new TestCaseActionRunnable(
                                            TestCaseActionType.CROSS_CAR,
                                            this.executionArg,
                                            stateRecords));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } finally {
                            latch.countDown();
                        }
                    }
                });
            }
        }
        latch.await();

        Assertions.assertThat(stateRecords)
                .as("Should contain valid states")
                .hasSameSizeAs(want.want())
                .isEqualTo(want.want().stream()
                        .map(ExpectationState::state)
                        .toList());
    }

    static Stream<Arguments> argumentSource() {
        return Stream.of(
                Arguments.of(
                        "case: " +
                                "cars = [1,3,5,2,4], " +
                                "directions = [2,1,2,4,3], " +
                                "arrivalTimes = [10,20,30,40,50]",
                        new Args(List.of(
                                new Arg(1, 2, 10L),
                                new Arg(3, 1, 20L),
                                new Arg(5, 2, 30L),
                                new Arg(2, 4, 40L),
                                new Arg(4, 3, 50L))),
                        new Expectations(List.of(
                                new ExpectationState(0, "1112", "Car 1 Has Passed Road A In Direction 2"),
                                new ExpectationState(1, "1311", "Car 3 Has Passed Road A In Direction 1"),
                                new ExpectationState(2, "1512", "Car 5 Has Passed Road A In Direction 2"),
                                new ExpectationState(3, "2000", "Traffic Light On Road B Is Green"),
                                new ExpectationState(4, "2224", "Car 2 Has Passed Road B In Direction 4"),
                                new ExpectationState(5, "2423", "Car 4 Has Passed Road B In Direction 3")))),
                Arguments.of(
                        "case: " +
                                "cars = [1,2,3,4,5], " +
                                "directions = [2,4,3,3,1], " +
                                "arrivalTimes = [10,20,30,40,40]",
                        new Args(List.of(
                                new Arg(1, 2, 10L),
                                new Arg(2, 4, 20L),
                                new Arg(3, 3, 30L),
                                new Arg(4, 3, 40L),
                                new Arg(5, 1, 40L))),
                        new Expectations(List.of(
                                new ExpectationState(0, "1112", "Car 1 Has Passed Road A In Direction 2"),
                                new ExpectationState(1, "2000", "Traffic Light On Road B Is Green"),
                                new ExpectationState(2, "2224", "Car 2 Has Passed Road B In Direction 4"),
                                new ExpectationState(3, "2323", "Car 3 Has Passed Road B In Direction 3"),
                                new ExpectationState(4, "2423", "Car 4 Has Passed Road B In Direction 3"),
                                new ExpectationState(5, "1000", "Traffic Light On Road A Is Green"),
                                new ExpectationState(6, "1511", "Car 5 Has Passed Road A In Direction 1")))),
                Arguments.of(
                        "case: " +
                                "cars = [3,4,1,5,2], " +
                                "directions = [4,3,2,3,3], " +
                                "arrivalTimes = [50,51,52,53,54]",
                        new Args(List.of(
                                new Arg(3, 4, 50L),
                                new Arg(4, 3, 51L),
                                new Arg(1, 2, 52L),
                                new Arg(5, 3, 53L),
                                new Arg(2, 3, 54L))),
                        new Expectations(List.of(
                                new ExpectationState(0, "2000", "Traffic Light On Road B Is Green"),
                                new ExpectationState(0, "2324", "Car 3 Has Passed Road B In Direction 4"),
                                new ExpectationState(0, "2423", "Car 4 Has Passed Road B In Direction 3"),
                                new ExpectationState(0, "1000", "Traffic Light On Road A Is Green"),
                                new ExpectationState(0, "1112", "Car 1 Has Passed Road A In Direction 2"),
                                new ExpectationState(0, "2000", "Traffic Light On Road B Is Green"),
                                new ExpectationState(0, "2523", "Car 5 Has Passed Road B In Direction 3"),
                                new ExpectationState(0, "2223", "Car 2 Has Passed Road B In Direction 3"))))
        );
    }

    record Args(List<Arg> args) {
    }

    record Arg(int carId, int direction, long arrivalTime) {
    }

    record Expectations(List<ExpectationState> want) {
    }

    record ExpectationState(Integer id, String state, String description) {
    }

    record TestExecutionArg(boolean shouldChangeSignal, int carId, int roadId, int direction) {
    }

    private static TestExecutionArg toTestExecutionArg(Arg arg, boolean shouldChangeSignal) {
        var roadId = toRoadId(arg.direction());
        if (!shouldChangeSignal) {
            return new TestExecutionArg(
                    false,
                    arg.carId(),
                    roadId,
                    arg.direction());
        }
        return new TestExecutionArg(
                true,
                arg.carId(),
                roadId,
                arg.direction());
    }

    private static String toState(int... values) {
        var sb = new StringBuilder();
        for (var val : values) {
            sb.append(val);
        }
        return sb.toString();
    }

    private static int toRoadId(int direction) {
        return direction == 1 || direction == 2 ? 1 : 2;
    }

    private static class InternalTestRunnable implements Runnable {
        protected final TestExecutionArg executionArg;
        protected final Long delayInMillis;

        private InternalTestRunnable(TestExecutionArg executionArg, Long delayInMillis) {
            this.executionArg = executionArg;
            this.delayInMillis = delayInMillis;
        }

        @Override
        public void run() {
            // NOOP
        }
    }

    private enum TestCaseActionType {
        TURN_GREEN,
        CROSS_CAR
    }

    private static class TestCaseActionRunnable implements Runnable {
        private final TestCaseActionType actionType;
        private final TestExecutionArg executionArg;
        private final List<String> stateRecords;

        private TestCaseActionRunnable(TestCaseActionType actionType, TestExecutionArg executionArg, List<String> stateRecords) {
            this.actionType = actionType;
            this.executionArg = executionArg;
            this.stateRecords = stateRecords;
        }

        @Override
        public void run() {
            if (TestCaseActionType.TURN_GREEN.equals(this.actionType) && this.executionArg.shouldChangeSignal()) {
                this.stateRecords.add(toState(
                        this.executionArg.roadId(),
                        0,
                        0,
                        0));
            } else if (TestCaseActionType.CROSS_CAR.equals(this.actionType)) {
                this.stateRecords.add(toState(
                        this.executionArg.roadId(),
                        this.executionArg.carId(),
                        this.executionArg.roadId(),
                        this.executionArg.direction()));
            }
        }
    }
}