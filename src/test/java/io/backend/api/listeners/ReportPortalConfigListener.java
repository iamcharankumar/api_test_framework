package io.backend.api.listeners;

import com.epam.reportportal.testng.BaseTestNGListener;

public class ReportPortalConfigListener extends BaseTestNGListener {

    public ReportPortalConfigListener() {
        super(new ReportPortalOverrideParameters());
    }
}