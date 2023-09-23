package io.backend.api.zippo.tests;


import io.backend.api.base.BaseTest;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.commons.HttpStatuses;
import io.backend.entities.response.PostalCodeDetailsResponse;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Slf4j
public class PostalCodeTest extends BaseTest {

    @Test(description = "To verify, postal code details for the given country and pin code",
            dataProvider = "postal-codes", dataProviderClass = ApiDataProvider.class)
    public void testPostalCodeDetails(String country, String pinCode) {
        Map<Response, PostalCodeDetailsResponse> postalCodeDetailsResponse =
                API_CONTROLLERS.getPostalCodeDetailsResponse(country, pinCode);
        Response response = (Response) postalCodeDetailsResponse.keySet().toArray()[0];
        PostalCodeDetailsResponse responseBody = (PostalCodeDetailsResponse) postalCodeDetailsResponse.values().toArray()[0];
        Assert.assertEquals(response.statusCode(), HttpStatuses.OK.getCode(), "Postal Code Success Status Failed!");
        Assert.assertEquals(responseBody.getCountry(), "United States", "Postal Code Country Mismatched!");
        Assert.assertEquals(responseBody.getPostCode(), pinCode, "Post Code pin code Mismatched!");
        log.info("Verified the Postal Code details with country {} and pin code {}",
                responseBody.getCountry(), responseBody.getPostCode());
    }
}