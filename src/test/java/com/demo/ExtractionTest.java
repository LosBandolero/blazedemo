package com.demo;

import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExtractionTest extends BaseTest {

    @Test
    public void bookFlightEndToEnd() {
        String fromCity = prepareGet(DEPARTURE_ALL_BY_ID).extract().path("city");
        String toCity = prepareGet(ARRIVAL_ALL_BY_ID).extract().path("city");

        String jsonCities = "{\"from\":\"" + fromCity +
                "\", \"to\":\"" + toCity +
                "\"}";
        String flightId = preparePost("search", jsonCities).then().extract().path("id");

        String cardNumber = "2864528645765429346";

        String jsonUserData = "{\n" +
                "\t\"name\": \"Greg\",\n" +
                "\t\"address\": \"somewhere\",\n" +
                "\t\"city\": \"yerevan\",\n" +
                "\t\"state\": \"hayastan\",\n" +
                "\t\"zipCode\": \"0006\",\n" +
                "\t\"cardType\": \"master\",\n" +
                "\t\"cardNumber\": \"" + cardNumber + "\",\n" +
                "\t\"cardExpirationMonth\": 9,\n" +
                "\t\"cardExpirationYear\": 20,\n" +
                "\t\"cardNameOnCard\": \"Greg\",\n" +
                "\t\"flightId\": " + flightId + "\n" +
                "}";

        Response resultJson = preparePost("users/", jsonUserData)

                .then()
                .extract().response();

        String cN = resultJson.path("cardNumber");
        int id = resultJson.path("id");
        assertEquals(cardNumber, cN);

        //clean up of DB
        prepareDelete("users/" + id)
                .statusCode(200);
    }
}
