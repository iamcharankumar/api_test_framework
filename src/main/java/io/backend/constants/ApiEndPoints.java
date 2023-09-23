package io.backend.constants;

import io.backend.utils.PropertiesHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiEndPoints {

    private static final PropertiesHelper API_PROPERTIES = new PropertiesHelper();
    private static final String API_PROPERTY_FILE = System.getProperty("user.dir") + "/src/main/java/resource/api.properties";

    private static String getZipposHost() {
        return API_PROPERTIES.getProperty(API_PROPERTY_FILE, "ZIPPOS_HOST");
    }

    private static String getDummyHost() {
        return API_PROPERTIES.getProperty(API_PROPERTY_FILE, "DUMMY_HOST");
    }

    private static String getReqresHost() {
        return API_PROPERTIES.getProperty(API_PROPERTY_FILE, "REQRES_HOST");
    }

    public static final String GET_POSTAL_CODE_INFO = getZipposHost();
    public static final String POST_CREATE_EMPLOYEE = getDummyHost() + "/api/v1/create";
    public static final String POST_CREATE_USER = getReqresHost() + "/api/users";
}