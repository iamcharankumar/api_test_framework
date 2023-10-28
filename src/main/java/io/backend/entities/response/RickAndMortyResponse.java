package io.backend.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RickAndMortyResponse {
    private int id;
    private String name;
    private String status;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Origin {
        private String name;
        private String url;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Location {
        String name;
        String url;
    }

    private String image;
    private List<String> episode;
    private String url;
    private String created;
}
