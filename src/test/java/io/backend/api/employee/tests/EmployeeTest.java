package io.backend.api.employee.tests;

import io.backend.api.base.BaseTest;
import io.backend.commons.HttpStatuses;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.request.CreateEmployeeRequest;
import io.backend.entities.response.CreateEmployeeResponse;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Slf4j
public class EmployeeTest extends BaseTest {

    @Test(description = "To verify, postal code details for the given country and pin code",
            dataProvider = "create-employee", dataProviderClass = ApiDataProvider.class)
    public void testCreateEmployee(String name, String salary, String age) {
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest(name, salary, age);
        Map<Response, CreateEmployeeResponse> createEmployeeResponse =
                API_CONTROLLERS.getCreateEmployeeResponse(createEmployeeRequest);
        Response response = (Response) createEmployeeResponse.keySet().toArray()[0];
        CreateEmployeeResponse responseBody = (CreateEmployeeResponse) createEmployeeResponse.values().toArray()[0];
        Assert.assertEquals(response.statusCode(), HttpStatuses.OK.getCode(),
                "Create Employee Success Status Code Failed!");
        Assert.assertEquals(responseBody.getStatus(), "success", "Create Employee Status Failed!");
        Assert.assertTrue(responseBody.getData().getId() > 0, "Create Employee ID Failed!");
        Assert.assertEquals(responseBody.getData().getMessage(), "Successfully! Record has been added.",
                "Create Employee Message Failed!");
        log.info("Verified the status code {} with employee success status {} for employee id {}",
                response.statusCode(), responseBody.getStatus(), responseBody.getData().getId());
    }
}