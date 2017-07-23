package com.demo.bdd.steps;

import com.demo.bdd.BlazeMetterFeatureTest;
import cucumber.api.java.en.When;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class FlightSteps extends BlazeMetterFeatureTest {
    private static final Logger LOGGER = getLogger(FlightSteps.class);

    @When("^User gets one flight by id (\\d+)$")
    public void userGetsOneFlightById(int id) throws Throwable {
        LOGGER.info("When - User gets one flight by id [{}]", id);
    }
}
