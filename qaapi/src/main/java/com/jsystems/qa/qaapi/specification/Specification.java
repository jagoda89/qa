package com.jsystems.qa.qaapi.specification;

import com.jsystems.qa.qaapi.configuration.ApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public static RequestSpecification fakeAzureSpecBuilder(){

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(ApiConfig.BASE_AZURE_HOST)
                .build();
    }
}
