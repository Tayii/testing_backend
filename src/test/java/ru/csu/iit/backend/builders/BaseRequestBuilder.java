package ru.csu.iit.backend.builders;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.*;

public class BaseRequestBuilder {
    protected RequestSpecification requestSpecification;
    protected JsonObject bodyFields;

    public BaseRequestBuilder(RequestSpecification requestSpecification) {
        bodyFields = new JsonObject();
        this.requestSpecification = requestSpecification;
    }

    public BaseRequestBuilder addAuthorization(Properties properties) {
        requestSpecification.queryParams("access_token", properties.getProperty("access_token"));
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification.contentType(ContentType.URLENC);
    }
}
