package ru.csu.iit.backend.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.SongRequestBuilder;

import java.util.Properties;

public class SongService extends BaseService {
    public SongService(Properties properties) {
        super(properties);
    }

    public SongRequestBuilder requestBuilder() {
        return new SongRequestBuilder(baseRequest());
    }

    public String removeSong(RequestSpecification requestSpecification) {
        return executeRemoveSong(requestSpecification).then()
                .extract()
                .body()
                .asString();
    }

    public Response executeRemoveSong(RequestSpecification requestSpecification) {
        return requestSpecification.post("command_remove.php");
    }
}
