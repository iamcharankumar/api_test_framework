package io.backend.utils;

import io.backend.constants.ApiConstants;
import io.backend.exceptions.ReqresTestException;
import io.backend.exceptions.RickAndMortyTestException;
import io.backend.exceptions.ZipposTestException;

import java.util.Properties;

public class ConfigLoader {
    private final Properties PROPERTIES;
    private static ConfigLoader instance;

    private ConfigLoader() {
        PROPERTIES = PropertiesHelper.loadProperties(ApiConstants.API_PROPERTY_FILE);
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
        String zipposHost = PROPERTIES.getProperty("ZIPPOS_HOST");
        if (zipposHost != null)
            return zipposHost;
        else
            throw new ZipposTestException("Zippos Host failed to load from the properties file!");
    }

    public String getReqresHost() {
        String reqresHost = PROPERTIES.getProperty("REQRES_HOST");
        if (reqresHost != null)
            return reqresHost;
        else
            throw new ReqresTestException("Reqres Host failed to load from the properties file!");
    }

    public String getRickAndMortyHost() {
        String rickAndMortyHost = PROPERTIES.getProperty("RICK_AND_MORTY_HOST");
        if (rickAndMortyHost != null)
            return rickAndMortyHost;
        else throw new RickAndMortyTestException("Rick And Morty Host failed to load from the properties file!");
    }
}