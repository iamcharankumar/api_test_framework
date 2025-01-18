package io.backend.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IfscCodeDetailsResponse(
        @JsonProperty(value = "BRANCH") String branch,
        @JsonProperty(value = "CENTRE") String centre,
        @JsonProperty(value = "DISTRICT") String district,
        @JsonProperty(value = "STATE") String state,
        @JsonProperty(value = "ADDRESS") String address,
        @JsonProperty(value = "CONTACT") String contact,
        @JsonProperty(value = "IMPS") boolean imps,
        @JsonProperty(value = "CITY") String city,
        @JsonProperty(value = "UPI") boolean upi,
        @JsonProperty(value = "MICR") String micr,
        @JsonProperty(value = "RTGS") boolean rtgs,
        @JsonProperty(value = "NEFT") boolean neft,
        @JsonProperty(value = "SWIFT") String swift,
        @JsonProperty(value = "ISO3166") String iso3166,
        @JsonProperty(value = "BANK") String bank,
        @JsonProperty(value = "IFSC") String ifsc
) {
}