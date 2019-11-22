package com.jsystems.qa.qaapi.service.azure;

import com.jsystems.qa.qaapi.model.azure.author.AzureAuthor;
import com.jsystems.qa.qaapi.specification.Specification;
import io.restassured.RestAssured;

import java.util.List;

public class AuthorService {

    private static final String API_AUTHORS = "/api/Authors";

    public static List<AzureAuthor> getAzureAuthors(){
        return RestAssured.given()
                .spec(Specification.fakeAzureSpecBuilder())
                .when()
                .get(API_AUTHORS)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", AzureAuthor.class);

    }
}
