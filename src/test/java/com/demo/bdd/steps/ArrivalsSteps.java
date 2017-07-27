package com.demo.bdd.steps;

import com.demo.bdd.BlazeMeterFeatureTest;
import cucumber.api.java.en.When;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class ArrivalsSteps extends BlazeMeterFeatureTest {

    private static final Logger LOGGER = getLogger(ArrivalsSteps.class);

    @When("^User gets one* arrival by id (\\d+)$")
    public void userGetsOneArrivalById(int id) throws Throwable {
        LOGGER.info("When - User gets one arrival by id [{}]", id);
    }
}