package com.demo;

import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.lessThan;

public class ArrivalTest extends BaseTest {

    @Test
    public void checkArrivalEndpointStatus() {
        prepareGet(ARRIVAL_ALL).statusCode(SC_OK);
    }

    @Test
    public void checkSchemaValidity() {
        prepareGet(ARRIVAL_ALL)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/arrival_schema.json"));
    }

    @Test
    public void checkResponseTimeAll() {
        prepareGet(ARRIVAL_ALL)
                .time(lessThan(2000L));
    }

    @Test
    public void checkResponseTimeById() {
        prepareGet(ARRIVAL_ALL_BY_ID)
                .time(lessThan(ENDPOINT_RESPONSE_TIME));
    }

    /*
     * Negative testing section
     */
    @Test
    public void checkPutMethod() {
        preparePut(ARRIVAL_ALL_BY_ID, DUMMY_TEST_JSON)
                .then()
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void checkPostMethod() {
        preparePost(ARRIVAL_ALL, DUMMY_TEST_JSON)
                .then()
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void checkDeleteMethod() {
        prepareDelete(ARRIVAL_ALL_BY_ID)
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }
}
