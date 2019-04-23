package logger;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public interface TestLifecycleLogger {
    Logger LOG = Logger.getLogger(TestLifecycleLogger.class.getName());

    @BeforeAll
    static void beforeAllTests() {
        LOG.info("Before all tests \n /--------------------------/");
    }

    @AfterAll
    static void afterAllTests() {
        LOG.info("After all tests \n /--------------------------/");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("About to execute [%s] \n /--------------------------/",
                testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("Finished executing [%s] \n /--------------------------/",
                testInfo.getDisplayName()));
    }
}
