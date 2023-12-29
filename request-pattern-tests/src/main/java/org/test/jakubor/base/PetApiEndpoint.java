package org.test.jakubor.base;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.swagger.client.api.PetApi;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.swagger.client.GsonObjectMapper.gson;

public abstract class PetApiEndpoint<E, M> extends BaseEndpoint<E, M> implements RestService<PetApi> {

    @Override
    public PetApi getServiceApi() {
        return PetApi.pet(new RequestSpecBuilder()
                .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                .addFilter(new ErrorLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setBaseUri("https://petstore.swagger.io//v2"));
    }

}
