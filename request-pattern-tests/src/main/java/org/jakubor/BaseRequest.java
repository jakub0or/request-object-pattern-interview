package org.jakubor;

import io.restassured.response.Response;

import java.lang.reflect.Type;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseRequest<E, M> {

    protected Response response;

    protected abstract Type getModelType();

    public abstract E sendRequest();

    public M getResponseModel() {
        return response.as(getModelType());
    }

    public E assertStatusCode(int statusCode) {
        assertThat(response.getStatusCode()).isEqualTo(statusCode);
        return (E) this;
    }
}
