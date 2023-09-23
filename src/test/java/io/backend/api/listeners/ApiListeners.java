package io.backend.api.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.*;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class ApiListeners implements ITestListener, ISuiteListener, IRetryAnalyzer {

    private Instant startDate;
    private int count = 0;
    private static final int MAX_RETRY = 3;

    @Override
    public void onStart(ISuite suite) {
        startDate = Instant.now();
        log.info("API Test Suite Started executing at {}.", startDate);
    }

    @Override
    public void onFinish(ISuite suite) {
        Instant endDate = Instant.now();
        Duration timeElapsed = Duration.between(startDate, endDate);
        log.info("API Suite Finished executing in {} seconds.", timeElapsed.getSeconds());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test Method {} is success.", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test Method {} failed.", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test Method {} skipped.", result.getName());
    }

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < MAX_RETRY) {
                log.info("Retrying test for {} time(s) for the test method {} with test status {}.",
                        count + 1, result.getName(), getTestStatus(result.getStatus()));
                count++;
                return true;
            }
        }
        log.info("Retrying for the test method {} is exhausted.", result.getName());
        return false;
    }

    private String getTestStatus(int status) {
        return switch (status) {
            case 1 -> "SUCCESS";
            case 2 -> "FAILED";
            case 3 -> "SKIP";
            default -> null;
        };
    }
}
