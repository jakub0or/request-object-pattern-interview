package org.jakubor;

import io.swagger.client.model.Pet;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class PostPetStoreApiRequest extends BaseRequest<PostPetStoreApiRequest, Pet> {

    protected Pet pet;

    private static final String POST_PET_PATH = "pet";

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
        response = given()
                .basePath(POST_PET_PATH)
                .when()
                .body(this.pet)
                .post();
        return this;
    }
}
