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

    private static String getReqresHost() {
        return API_PROPERTIES.getProperty(API_PROPERTY_FILE, "REQRES_HOST");
    }

    private static String getRickAndMortyHost() {
        return API_PROPERTIES.getProperty(API_PROPERTY_FILE, "RICK_AND_MORTY_HOST");
    }

    public static final String GET_POSTAL_CODE_INFO = getZipposHost() + "/";
    public static final String POST_CREATE_USER = getReqresHost() + "/api/users";
    public static final String GET_RICK_AND_MORTY_CHARACTER = getRickAndMortyHost() + "/api/character/";
}