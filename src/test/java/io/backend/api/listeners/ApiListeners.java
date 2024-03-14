package io.backend.api.listeners;

import io.backend.utils.DateUtils;
import io.backend.utils.TestUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.Instant;

@Slf4j
public class ApiListeners implements ITestListener, ISuiteListener {

    private Instant startDate;

    @Override
    public void onStart(ISuite suite) {
        startDate = DateUtils.getCurrentInstantTimeStamp();
        log.info("API Test Suite '{}' Started executing at {}.", suite.getName(), startDate);
    }

    @Override
    public void onFinish(ISuite suite) {
        Instant endDate = DateUtils.getCurrentInstantTimeStamp();
        long timeElapsed = DateUtils.getDurationBetweenTimeStamps(startDate, endDate);
        log.info("API Suite Finished executing in {} seconds.", timeElapsed);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test Method {} is PASS.", TestUtils.concatenateTestMethodTestData(result, result.getParameters()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test Method {} is FAIL.", TestUtils.concatenateTestMethodTestData(result, result.getParameters()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test Method {} SKIP.", TestUtils.concatenateTestMethodTestData(result, result.getParameters()));
    }
}
