package io.backend.api.listeners;

import com.epam.reportportal.listeners.ListenerParameters;
import com.epam.reportportal.service.Launch;
import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.TestNGService;
import com.epam.reportportal.utils.properties.PropertiesLoader;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;
import org.testng.util.Strings;

import java.util.Calendar;
import java.util.function.Supplier;

public class ReportPortalOverrideParameters extends TestNGService {
    public ReportPortalOverrideParameters() {
        super(getReportPortalProperties());
    }

    public static Supplier<Launch> getReportPortalProperties() {
        ListenerParameters parameters = new ListenerParameters(PropertiesLoader.load());
        parameters.setBaseUrl("http://localhost:8080");
        parameters.setApiKey("");
        parameters.setLaunchName("api_test_launch");
        parameters.setProjectName("api_tests");
        ReportPortal reportPortal = ReportPortal.builder().withParameters(parameters).build();
        StartLaunchRQ startLaunch = buildReportPortalLaunch(parameters);
        return () -> reportPortal.newLaunch(startLaunch);
    }

    public static StartLaunchRQ buildReportPortalLaunch(ListenerParameters parameters) {
        StartLaunchRQ launchStart = new StartLaunchRQ();
        launchStart.setName(parameters.getLaunchName());
        launchStart.setStartTime(Calendar.getInstance().getTime());
        launchStart.setAttributes(parameters.getAttributes());
        launchStart.setMode(parameters.getLaunchRunningMode());
        if (!Strings.isNullOrEmpty(parameters.getDescription())) {
            launchStart.setDescription(parameters.getDescription());
        }
        return launchStart;
    }
}