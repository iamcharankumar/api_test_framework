package io.backend.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostalCodeDetailsResponse(@JsonProperty("post code") String postCode, String country,
                                        @JsonProperty("country abbreviation") String countryAbbreviation) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static record Places(@JsonProperty("place name") String placeName, String longitude,
                                 String state, @JsonProperty("state abbreviation") String stateAbbreviation,
                                 String latitude) {
    }
}