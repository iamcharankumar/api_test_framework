package io.backend.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class IfscCodeDetailsResponse {

    @JsonProperty(value = "BRANCH")
    private String branch;
    @JsonProperty(value = "CENTRE")
    private String centre;
    @JsonProperty(value = "DISTRICT")
    private String district;
    @JsonProperty(value = "STATE")
    private String state;
    @JsonProperty(value = "ADDRESS")
    private String address;
    @JsonProperty(value = "CONTACT")
    private String contact;
    @JsonProperty(value = "IMPS")
    private boolean imps;
    @JsonProperty(value = "CITY")
    private String city;
    @JsonProperty(value = "UPI")
    private boolean upi;
    @JsonProperty(value = "MICR")
    private String micr;
    @JsonProperty(value = "RTGS")
    private boolean rtgs;
    @JsonProperty(value = "NEFT")
    private boolean neft;
    @JsonProperty(value = "SWIFT")
    private String swift;
    @JsonProperty(value = "ISO3166")
    private String iso3166;
    @JsonProperty(value = "BANK")
    private String bank;
    @JsonProperty(value = "IFSC")
    private String ifsc;
}