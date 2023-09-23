package io.backend.api.testdata;

import org.testng.annotations.DataProvider;

public class ApiDataProvider {

    @DataProvider(name = "postal-codes")
    private Object[][] postalCodes() {
        return new Object[][]{{"us", "90210"}};
    }

    @DataProvider(name = "create-employee")
    private Object[][] createEmployee() {
        return new Object[][]{
                {"test", "123", "23"}
        };
    }

    @DataProvider(name = "create-user")
    private Object[][] createUser() {
        return new Object[][]{
                {"morpheus", "leader"}
        };
    }
}