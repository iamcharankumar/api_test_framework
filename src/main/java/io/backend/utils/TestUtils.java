package io.backend.utils;

import io.backend.exceptions.TestUtilsException;
import org.testng.ITestResult;

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
}