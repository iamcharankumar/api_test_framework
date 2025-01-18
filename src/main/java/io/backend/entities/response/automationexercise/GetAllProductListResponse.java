package io.backend.entities.response.automationexercise;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetAllProductListResponse(int responseCode, List<Products> products) {
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static record Products(Integer id, String name, String price, String brand, Category category) {

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static record Category(String category, Usertype usertype) {

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static record Usertype(String usertype) {

            }
        }
    }
}