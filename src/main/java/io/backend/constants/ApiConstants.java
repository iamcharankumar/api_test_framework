package io.backend.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiConstants {

    public static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    public static final String API_PROPERTY_FILE = CURRENT_DIRECTORY + "/src/main/java/resource/api.properties";
    public static final String WEBHOOK_TOKEN = "1223572496326856744/OHOraeNSODx3KhRlQBhj-9eRGr9qcLBF0cyG4XCMgeR4ce5gcp9JAnkuXhZuKNtHBvq9";
    public static final String CONTENT_TYPE = "application/json";
}