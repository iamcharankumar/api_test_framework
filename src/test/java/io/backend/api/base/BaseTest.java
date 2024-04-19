package io.backend.api.base;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;


@Slf4j
public class BaseTest {

    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    protected void setUp(Method method) {
        log.info("Started Executing the test method {}", method.getName());
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(Method method) {
        log.info("Completed Executing the test method {}", method.getName());
    }
}