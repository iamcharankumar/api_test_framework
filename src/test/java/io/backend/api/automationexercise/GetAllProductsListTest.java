package io.backend.api.automationexercise;

import io.backend.api.base.BaseTest;
import io.backend.api.constants.TestGroups;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.commons.HttpStatuses;
import io.backend.entities.response.automationexercise.GetAllProductListResponse;
import io.backend.exceptions.ApiTestException;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

@Slf4j
public class GetAllProductsListTest extends BaseTest {

    @Test(description = "To verify, all the product details.", dataProvider = "get-all-products", dataProviderClass = ApiDataProvider.class,
            groups = {TestGroups.ALL_REGRESSION, TestGroups.AUTOMATION_EXERCISE_REGRESSION})
    public void testGetAllProductsList(GetAllProductListResponse productListResponse, int expectedId, String expectedName,
                                       String expectedPrice, String expectedBrand, String expectedUserType, String expectedCategory) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productListResponse.responseCode(), HttpStatuses.OK.getCode(), "Get All Products List Response Code Mismatched!");
        List<GetAllProductListResponse.Products> productsList = productListResponse.products();
        int actualId = productsList.stream().filter(Objects::nonNull)
                .filter(id -> id.id().equals(expectedId)).findFirst()
                .orElseThrow(() -> new ApiTestException("Test Data: Invalid Product ID!")).id();
        softAssert.assertEquals(actualId, expectedId, "Get All Products List ID Mismatched!");
        String actualName = productsList.stream().filter(Objects::nonNull)
                .filter(name -> name.name().equals(expectedName)).findFirst()
                .orElseThrow(() -> new ApiTestException("Test Data: Invalid Product Name!")).name();
        softAssert.assertEquals(actualName, expectedName, "Get All Products List Name Mismatched!");
        String actualPrice = productsList.stream().filter(Objects::nonNull)
                .filter(price -> price.price().equals(expectedPrice)).findFirst()
                .orElseThrow(() -> new ApiTestException("Test Data: Invalid Product Price!")).price();
        softAssert.assertEquals(actualPrice, expectedPrice, "Get All Products List Price Mismatched!");
        String actualBrand = productsList.stream().filter(Objects::nonNull)
                .filter(brand -> brand.brand().equals(expectedBrand)).findFirst()
                .orElseThrow(() -> new ApiTestException("Test Data: ")).brand();
        softAssert.assertEquals(actualBrand, expectedBrand, "Get All Products List Brand Mismatched!");
        String actualCategory = productsList.stream().filter(Objects::nonNull)
                .filter(category -> category.category().category().equals(expectedCategory)).findFirst()
                .orElseThrow(() -> new ApiTestException("Test Data: Invalid Product Category!")).category().category();
        softAssert.assertEquals(actualCategory, expectedCategory, "Get All Products List Category Mismatched!");
        String actualUserType = productsList.stream().filter(Objects::nonNull)
                .filter(userType -> userType.category().usertype().usertype().equals(expectedUserType))
                .findFirst().orElseThrow(() -> new ApiTestException("Test Data: Invalid user type!"))
                .category().usertype().usertype();
        softAssert.assertEquals(actualUserType, expectedUserType, "Get All Products List User Type Mismatched!");
        softAssert.assertAll();
        log.info("Verified the Product Details: {}, {}, {}, {}, {}, {}", actualId, actualName, actualPrice, actualBrand, actualCategory, actualUserType);
    }
}