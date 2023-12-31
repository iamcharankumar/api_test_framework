package io.backend.api.reqres.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.request.CreateUsersRequest;
import io.backend.entities.response.CreateUserResponse;
import io.backend.services.ApiHelpers;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class ReqresTest extends BaseTest {

    @Test(description = "To verify, postal code details for the given country and pin code",
            dataProvider = "create-user", dataProviderClass = ApiDataProvider.class)
    public void testUserDetails(String name, String job) {
        SoftAssert softAssert = new SoftAssert();
        CreateUsersRequest createUsersRequest = new CreateUsersRequest(name, job);
        CreateUserResponse responseBody = ApiHelpers.getApiControllers().getCreateUserResponse(createUsersRequest);
        softAssert.assertFalse(responseBody.getId().isEmpty(), "Create User ID is empty!");
        softAssert.assertFalse(responseBody.getCreatedAt().isEmpty(), "Create User date is empty!");
        log.info("Verified the Create User API with name {} and job {}", name, job);
        softAssert.assertAll();
    }
}