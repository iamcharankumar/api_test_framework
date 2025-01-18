package io.backend.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RickAndMortyResponse(int id, String name, String status, String type, String gender, Origin origin,
                                   Location location, String image, List<String> episode, String url, String created) {
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static record Origin(String name, String url) {

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static record Location(String name, String url) {

    }
}