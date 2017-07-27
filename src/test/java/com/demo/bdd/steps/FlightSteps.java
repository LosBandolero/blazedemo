package com.demo.bdd.steps;

import com.demo.bdd.BlazeMeterFeatureTest;
import cucumber.api.java.en.When;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class FlightSteps extends BlazeMeterFeatureTest {
    private static final Logger LOGGER = getLogger(FlightSteps.class);

    @When("^User gets one flight by id (\\d+)$")
    public void userGetsOneFlightById(int id) throws Throwable {
        LOGGER.info("When - User gets one flight by id [{}]", id);
    }
}
