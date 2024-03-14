package io.backend.api.zippo.tests;


import io.backend.api.base.BaseTest;
import io.backend.api.constants.TestGroups;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.response.PostalCodeDetailsResponse;
import io.backend.services.ApiHelpers;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class PostalCodeTest extends BaseTest {

    @Test(description = "To verify, postal code details for the given country and pin code", dataProvider = "postal-codes",
            dataProviderClass = ApiDataProvider.class, groups = {TestGroups.ZIPPOS_SMOKE, TestGroups.ZIPPOS_REGRESSION,
            TestGroups.ALL_SMOKE, TestGroups.ALL_REGRESSION})
    public void testPostalCodeDetails(String country, String pinCode) {
        SoftAssert softAssert = new SoftAssert();
        PostalCodeDetailsResponse responseBody = ApiHelpers.getApiControllers().getPostalCodeDetailsResponse(country, pinCode);
        softAssert.assertEquals(responseBody.getCountry(), "United States", "Postal Code Country Mismatched!");
        softAssert.assertEquals(responseBody.getPostCode(), pinCode, "Post Code pin code Mismatched!");
        log.info("Verified the Postal Code details with country {} and pin code {}",
                responseBody.getCountry(), responseBody.getPostCode());
        softAssert.assertAll();
    }
}