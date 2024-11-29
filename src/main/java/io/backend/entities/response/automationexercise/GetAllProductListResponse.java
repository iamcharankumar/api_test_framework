package io.backend.entities.response.automationexercise;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllProductListResponse {

    private int responseCode;
    private List<Products> products;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Products {
        private Integer id;
        private String name;
        private String price;
        private String brand;
        private Category category;

        @Getter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Category {

            private String category;
            private Usertype usertype;

            @Getter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Usertype {
                private String usertype;
            }
        }
    }
}
