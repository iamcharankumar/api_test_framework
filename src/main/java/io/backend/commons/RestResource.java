package io.backend.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import com.github.dzieciou.testing.curl.Platform;
import groovy.json.JsonException;
import io.backend.exceptions.RestResourceException;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestResource {

    private static RestResource instance;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Options OPTIONS = Options.builder().printMultiliner()
            .targetPlatform(Platform.WINDOWS).useShortForm().useLogLevel(Level.INFO).build();
    private static final RestAssuredConfig CONFIG = CurlRestAssuredConfigFactory.createConfig(OPTIONS);
    private static final String CONTENT_TYPE = "application/json";

    public static RestResource getInstance() {
        if (instance == null) {
            synchronized (RestResource.class) {
                if (instance == null) {
                    instance = new RestResource();
                }
            }
        }
        return instance;
    }

    public <T> T deserialize(Response response, Class<T> classVariable) throws JsonProcessingException {
        if (response == null)
            throw new RestResourceException("Deserialization: API Response is null!");
        return OBJECT_MAPPER.readValue(response.asString(), classVariable);
    }

    public String serialize(Object classObject) throws JsonProcessingException {
        if (classObject == null)
            throw new RestResourceException("Serialization: Class object is null!");
        return OBJECT_MAPPER.writeValueAsString(classObject);
    }

    public Response getApiResponse(String endPoint) {
        Response getResponse = RestAssured.given().config(CONFIG).when().get(endPoint);
        if (getResponse == null)
            throw new RestResourceException("GET API Call failed!");
        return getResponse;
    }

    public Response postApiResponse(String requestBody, String endPoint) throws JsonException {
        Response postResponse = RestAssured.given().contentType(CONTENT_TYPE).config(CONFIG).body(requestBody).when().post(endPoint);
        if (postResponse == null)
            throw new RestResourceException("POST API Call Failed!");
        return postResponse;
    }
}