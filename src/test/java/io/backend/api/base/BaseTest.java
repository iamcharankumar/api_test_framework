package io.backend.api.base;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;


@Slf4j
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        log.info("Started Executing the test method {}", method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
        log.info("Completed Executing the test method {}", method.getName());
    }
}