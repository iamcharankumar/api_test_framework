package io.backend.api.testdata;

import org.testng.annotations.DataProvider;

public class ApiDataProvider {

    @DataProvider(name = "postal-codes", parallel = true)
    private Object[][] postalCodes() {
        return new Object[][]{{"us", "90210"}};
    }

    @DataProvider(name = "create-employee", parallel = true)
    private Object[][] createEmployee() {
        return new Object[][]{
                {"test", "123", "23"}
        };
    }

    @DataProvider(name = "create-user", parallel = true)
    private Object[][] createUser() {
        return new Object[][]{
                {"morpheus", "leader"}
        };
    }

    @DataProvider(name = "rick-and-morty-characters", parallel = true)
    private Object[][] rickAndMortyCharacters() {
        return new Object[][]{
                {50, "Blim Blam", "Alive", "unknown"},
                {290, "Rick Sanchez", "Dead", "Earth (Evil Rick's Target Dimension)"},
                {303, "Samantha", "Alive", "Earth (C-137)"},
                {473, "Bartender Morty", "Alive", "unknown"},
                {572, "Robot Snake", "unknown", "Snake Planet"},
                {653, "Plane Crash Survivor", "unknown", "Near-Duplicate Reality"}
        };
    }

    @DataProvider(name = "ifsc-code", parallel = true)
    private Object[][] ifscCodes() {
        return new Object[][]{
                {"YESB0DNB002"},
                {"HDFC0000260"}
        };
    }
}