package io.backend.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEmployeeResponse {
    String status;
    Data data;
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        String message;
        int id;
    }
}