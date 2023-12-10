package io.backend.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiConstants {
    public static final String API_PROPERTY_FILE = System.getProperty("user.dir") + "/src/main/java/resource/api.properties";
}