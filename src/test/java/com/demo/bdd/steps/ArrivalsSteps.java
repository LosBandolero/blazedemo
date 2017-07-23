package com.demo.bdd.steps;

import com.demo.bdd.BlazeMetterFeatureTest;
import cucumber.api.java.en.When;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class ArrivalsSteps extends BlazeMetterFeatureTest {

    private static final Logger LOGGER = getLogger(ArrivalsSteps.class);

    @When("^User gets one* arrival by id (.+)")
    public void getOneArrival(int id) {
        LOGGER.info("When - User gets one arrival by id [{}]", id);
    }
}