package com.demo.rest;

import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.lessThan;

public class UsersTest extends BaseTest {
    @Test
    public void checkArrivalEndpointStatus() {
        prepareGet(USERS_ALL).statusCode(SC_OK);
    }

    @Test
    public void checkSchemaValidity() {
        prepareGet(USERS_ALL)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/users_schema.json"));
    }

    @Test
    public void checkResponseTimeAll() {
        prepareGet(USERS_ALL)
                .time(lessThan(ENDPOINT_RESPONSE_TIME));
    }

    @Test
    public void checkResponseTimeById() {
        prepareGet(USERS_ALL_BY_ID)
                .time(lessThan(ENDPOINT_RESPONSE_TIME));
    }

    /*
     * Negative testing section
     */
    @Test
    public void checkPutMethod() {
        preparePut(USERS_ALL_BY_ID, DUMMY_TEST_JSON)
                .then()
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void checkPostMethod() {
        preparePost(USERS_ALL, DUMMY_TEST_JSON)
                .then()
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }
}
