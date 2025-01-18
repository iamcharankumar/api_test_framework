package io.backend.api.ifsc.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.constants.TestGroups;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.response.IfscCodeDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class IfscCodeTest extends BaseTest {
    @Test(description = "To verify, the ifsc code details.", dataProvider = "ifsc-code", dataProviderClass = ApiDataProvider.class,
            groups = {TestGroups.IFSC_SMOKE, TestGroups.IFSC_REGRESSION, TestGroups.ALL_SMOKE, TestGroups.ALL_REGRESSION})
    public void testIfscCodeDetails(IfscCodeDetailsResponse ifscCodeDetailsResponse, String ifscCode) {
        Assert.assertEquals(ifscCodeDetailsResponse.ifsc(), ifscCode, "IFSC Code Mismatched!");
        log.info("Verified the IFSC Code Details for the given IFSC Code {}", ifscCode);
    }
}