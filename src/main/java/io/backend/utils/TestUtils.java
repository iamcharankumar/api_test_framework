package io.backend.utils;

import com.epam.reportportal.listeners.ListenerParameters;
import com.epam.reportportal.service.Launch;
import io.backend.exceptions.TestUtilsException;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;

import java.util.Optional;

@Slf4j
public class TestUtils {

    public static String concatenateTestMethodTestData(ITestResult result, Object[] testParameters) {
        StringBuilder testName = new StringBuilder();
        if (result != null) {
            if (result.getMethod().isDataDriven()) {
                testName.append(result.getName()).append("_");
                for (Object object : testParameters) {
                    testName.append(object.toString()).append("_");
                }
                return testName.substring(0, testName.length() - 1);
            } else
                return result.getName();
        } else
            throw new TestUtilsException("Test Method and Test Data Concatenation Failed!");
    }

    public static int calculateTestCasePercentage(int numberOfTestCases, int totalTestCases) {
        if (totalTestCases > 0) {
            double testCasePercentage = ((double) numberOfTestCases / totalTestCases) * 100;
            return (int) testCasePercentage;
        } else
            throw new TestUtilsException("Cannot be divided by Zero! Total Test Cases cannot be Zero.");
    }

    public static String getReportPortalLaunchUrl() {
        Launch launch = Optional.ofNullable(Launch.currentLaunch()).filter(currentLaunch -> currentLaunch != Launch.NOOP_LAUNCH)
                .orElse(null);
        if (launch == null)
            return "Report Portal Listener is disabled!";
        ListenerParameters parameters = launch.getParameters();
        String launchUuid = launch.getLaunch().blockingGet();
        String baseUrl = parameters.getBaseUrl();
        return baseUrl + "/ui/#" + parameters.getProjectName() + "/launches/all/" + launchUuid;
    }
}