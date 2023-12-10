package io.backend.api.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class ApiListeners implements ITestListener, ISuiteListener {

    private Instant startDate;

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
        log.info("Test Method {} is PASS.", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test Method {} FAIL.", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test Method {} SKIP.", result.getName());
    }
}
