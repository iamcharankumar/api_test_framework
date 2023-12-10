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
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;

@Slf4j
@NoArgsConstructor
public class RestResource {

    private final Options OPTIONS = Options.builder().printMultiliner().targetPlatform(Platform.WINDOWS)
            .useShortForm().useLogLevel(Level.INFO).build();
    private final RestAssuredConfig CONFIG = CurlRestAssuredConfigFactory.createConfig(OPTIONS);

    public <T> T deserialize(Response response, Class<T> classVariable) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.asString(), classVariable);
    }

    protected Response getApiResponse(String endPoint) throws JsonException {
        return RestAssured.given().config(CONFIG).when().get(endPoint);
    }

    protected Response postApiResponse(String requestBody, String endPoint) throws JsonException {
        return RestAssured.given().config(CONFIG).body(requestBody).when().post(endPoint);
    }
}