package io.backend.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalCodeDetailsResponse {

	@JsonProperty("post code")
	String postCode;
	String country;
	@JsonProperty("country abbreviation")
	String countryAbbreviation;

	@Getter
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Places {
		@JsonProperty("place name")
		String placeName;
		String longitude;
		String state;
		@JsonProperty("state abbreviation")
		String stateAbbreviation;
		String latitude;
	}
}