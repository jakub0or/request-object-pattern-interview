package org.test.jakubor.base;

import io.swagger.client.model.Pet;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.function.Function;

import static io.restassured.RestAssured.given;

public class GetPetApiRequest extends PetApiEndpoint<GetPetApiRequest, Pet> {

    private String petId;

    public GetPetApiRequest pet(String petId) {
        this.petId = petId;
        return this;
    }

    @Override
    public GetPetApiRequest sendRequest() {
        response = getServiceApi()
                .getPetById()
                .petIdPath(petId)
                .execute(Function.identity());
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    @Override
    protected Type getModelType() {
        return Pet.class;
    }

}