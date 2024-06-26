package io.backend.api.ifsc.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.constants.TestGroups;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.response.IfscCodeDetailsResponse;
import io.backend.services.rest.ApiHelpers;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class IfscCodeTest extends BaseTest {
    @Test(description = "To verify, the ifsc code details.", dataProvider = "ifsc-code", dataProviderClass = ApiDataProvider.class,
            groups = {TestGroups.IFSC_SMOKE, TestGroups.IFSC_REGRESSION, TestGroups.ALL_SMOKE, TestGroups.ALL_REGRESSION})
    public void testIfscCodeDetails(String ifscCode) {
        IfscCodeDetailsResponse responseBody = ApiHelpers.getApiControllers().getIfscCodeDetailsResponse(ifscCode);
        softAssert.assertEquals(responseBody.getIfsc(), ifscCode, "IFSC Code Mismatched!");
        softAssert.assertAll();
        log.info("Verified the IFSC Code Details for the given IFSC Code {}", ifscCode);
    }
}