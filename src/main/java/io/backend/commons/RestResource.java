package io.backend.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import com.github.dzieciou.testing.curl.Platform;
import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;

import java.util.Objects;

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

    public String serialize(Object classObject) throws JsonProcessingException {
        Objects.requireNonNull(classObject, "Serialization: Class object is null!");
        return OBJECT_MAPPER.writeValueAsString(classObject);
    }

    public <T> T deserialize(Response response, Class<T> classVariable) throws JsonProcessingException {
        Objects.requireNonNull(response, "Deserialization: API Response is null!");
        return OBJECT_MAPPER.readValue(response.asString(), classVariable);
    }

    public Response getApiResponse(String endPoint) {
        Response getResponse = RestAssured.given().log().all().request()
                .when().get(endPoint).then().log().all().extract().response();
        Objects.requireNonNull(getResponse, "GET API Call failed!");
        return getResponse;
    }

    public Response postApiResponse(String requestBody, String endPoint) throws JsonException {
        Response postResponse = RestAssured.given().contentType(CONTENT_TYPE)
                .body(requestBody).when().post(endPoint).then().log().all().extract().response();
        Objects.requireNonNull(postResponse, "POST API Call Failed!");
        return postResponse;
    }
}