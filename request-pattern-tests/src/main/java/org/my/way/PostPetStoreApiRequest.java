package org.my.way;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.swagger.client.model.Pet;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class PostPetStoreApiRequest extends BaseRequest<PostPetStoreApiRequest, Pet> {

    protected Pet pet;

    private static final String POST_PET_PATH = "pet";
    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setBaseUri("https://petstore3.swagger.io/api/v3")
            .setContentType(ContentType.JSON)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build();


    public PostPetStoreApiRequest pet(Pet pet) {
        this.pet = pet;
        return this;
    }

    @Override
    protected Type getModelType() {
        return Pet.class;
    }

    @Override
    public PostPetStoreApiRequest sendRequest() {
        response = given(requestSpecification)
                .basePath(POST_PET_PATH)
                .when()
                .body(this.pet)
                .post();
        return this;
    }
}
