package com.demo.rest;

import com.demo.BlazeMeterApi;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = BlazeMeterApi.class,
        webEnvironment = RANDOM_PORT
)
@ActiveProfiles("test")
public abstract class BaseTest {

    @LocalServerPort
    private int port;

    static final String ARRIVAL_ALL = "arrival/all";
    static final String ARRIVAL_ALL_BY_ID = "arrival/1";
    static final String DEPARTURE_ALL = "departure/all";
    static final String DEPARTURE_ALL_BY_ID = "departure/1";
    static final String FLIGHT_ALL = "flight/all";
    static final String FLIGHT_ALL_BY_ID = "flight/1";
    static final String USERS_ALL = "users/all";
    static final String USERS_ALL_BY_ID = "users/1";
    static final String DUMMY_TEST_JSON = "{ \"Test\": \"Test\" }";
    static final long ENDPOINT_RESPONSE_TIME = 200L;

    private static final String USER_NAME = "blaze";
    private static final String PASSWORD = "Q1w2e3r4";

    private String HOST_ROOT = "http://localhost/api/1.0/";

    ValidatableResponse prepareGet(String path) {
        return prepareGetDeleteWhen()
                .get(HOST_ROOT + path)
                .then();
    }

    ValidatableResponse prepareDelete(String path) {
        return prepareGetDeleteWhen()
                .delete(HOST_ROOT + path)
                .then();
    }

    Response preparePut(String path, String body) {
        return preparePostPutWhen(body)
                .put(HOST_ROOT + path);
    }

    Response preparePost(String path, String body) {
        return preparePostPutWhen(body)
                .post(HOST_ROOT + path);
    }

    private RequestSpecification preparePostPutWhen(String body) {
        return given()
                .port(port)
                .auth()
                .basic(USER_NAME, PASSWORD)
                .contentType(String.valueOf(APPLICATION_JSON))
                .body(body)
                .when();
    }

    private RequestSpecification prepareGetDeleteWhen() {
        return given()
                .port(port)
                .auth()
                .basic(USER_NAME, PASSWORD)
                .when();
    }
}
