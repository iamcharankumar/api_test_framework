package io.backend.utils;

import java.util.Objects;
import java.util.Properties;

public class ConfigLoader {

    private final Properties PROPERTIES;
    private static ConfigLoader instance;
    private static final String API_PROPERTY_FILE = "./src/main/java/resource/api.properties";

    private ConfigLoader() {
        PROPERTIES = PropertiesHelper.loadProperties(API_PROPERTY_FILE);
    }

    public static ConfigLoader getInstance() {
        if (instance == null) {
            synchronized (ConfigLoader.class) {
                if (instance == null)
                    instance = new ConfigLoader();
            }
        }
        return instance;
    }

    public String getZipposHost() {
        return getPropertyValue("ZIPPOS_HOST");
    }

    public String getReqresHost() {
        return getPropertyValue("REQRES_HOST");
    }

    public String getRickAndMortyHost() {
        return getPropertyValue("RICK_AND_MORTY_HOST");
    }

    public String getIfscCodeHost() {
        return getPropertyValue("IFSC_CODE_HOST");
    }

    public String getAutomationExerciseHost() {
        return getPropertyValue("AUTOMATION_EXERCISE");
    }

    public String getDiscordHost() {
        return getPropertyValue("DISCORD_HOST");
    }

    public String getPropertyValue(String propertyKey) {
        Objects.requireNonNull(propertyKey, "Property Value for Property Key: " + propertyKey + " is null or empty!");
        return PROPERTIES.getProperty(propertyKey);
    }
}