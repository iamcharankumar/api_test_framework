package io.backend.api.reqres.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.commons.HttpStatuses;
import io.backend.entities.request.CreateUsersRequest;
import io.backend.entities.response.CreateUserResponse;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Slf4j
public class ReqresTest extends BaseTest {

    @Test(description = "To verify, postal code details for the given country and pin code",
            dataProvider = "create-user", dataProviderClass = ApiDataProvider.class)
    public void testUserDetails(String name, String job) {
        CreateUsersRequest createUsersRequest = new CreateUsersRequest(name, job);
        Map<Response, CreateUserResponse> createUserResponse = API_CONTROLLERS.getCreateUserResponse(createUsersRequest);
        Response response = (Response) createUserResponse.keySet().toArray()[0];
        CreateUserResponse responseBody = (CreateUserResponse) createUserResponse.values().toArray()[0];
        Assert.assertEquals(response.getStatusCode(), HttpStatuses.CREATED.getCode(), "Create User Success Status Code Failed!");
        Assert.assertFalse(responseBody.getId().isEmpty(), "Create User ID is empty!");
        Assert.assertFalse(responseBody.getCreatedAt().isEmpty(), "Create User date is empty!");
        log.info("Verified the Create User API with status code {} name {} and job {}", response.getStatusCode(), name, job);
    }
}