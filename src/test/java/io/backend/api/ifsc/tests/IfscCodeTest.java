package io.backend.api.ifsc.tests;

import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.response.IfscCodeDetailsResponse;
import io.backend.services.ApiHelpers;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class IfscCodeTest {
    @Test(description = "To verify, the ifsc code details.", dataProvider = "ifsc-code", dataProviderClass = ApiDataProvider.class)
    public void testIfscCodeDetails(String ifscCode) {
        SoftAssert softAssert = new SoftAssert();
        IfscCodeDetailsResponse responseBody = ApiHelpers.getApiControllers().getIfscCodeDetailsResponse(ifscCode);
        softAssert.assertEquals(responseBody.getIfsc(), ifscCode, "IFSC Code Mismatched!");
        log.info("Verified the IFSC Code Details for the given IFSC Code {}", ifscCode);
        softAssert.assertAll();
    }
}