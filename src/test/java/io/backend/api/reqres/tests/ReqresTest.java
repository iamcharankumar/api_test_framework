package io.backend.api.reqres.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.constants.TestGroups;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.response.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class ReqresTest extends BaseTest {

    @Test(description = "To verify, postal code details for the given country and pin code", dataProvider = "create-user",
            dataProviderClass = ApiDataProvider.class, groups = {TestGroups.REQ_RES_SMOKE, TestGroups.REQ_RES_REGRESSION,
            TestGroups.ALL_SMOKE, TestGroups.ALL_REGRESSION})
    public void testUserDetails(CreateUserResponse createUserResponse) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(createUserResponse.getId().isEmpty(), "Create User ID is empty!");
        softAssert.assertFalse(createUserResponse.getCreatedAt().isEmpty(), "Create User date is empty!");
        softAssert.assertAll();
        log.info("Verified the Create User API with id {}", createUserResponse.getId());
    }
}