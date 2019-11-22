package com.jsystems.qa.qaapi.service.azure;

import com.jsystems.qa.qaapi.model.azure.author.AzureAuthor;
import com.jsystems.qa.qaapi.model.book.Book;
import com.jsystems.qa.qaapi.specification.Specification;
import io.restassured.RestAssured;

import java.util.List;

public class BookService {
    
    private  static final String API_BOOKS = "/api/Books";

    public static void postBook(Book book, int statusCode){
        RestAssured.given()
                .spec(Specification.fakeAzureSpecBuilder())
                .when()
                .body(book)
                .post(API_BOOKS)
                .then()
                .assertThat()
                .statusCode(statusCode);

    }
}
