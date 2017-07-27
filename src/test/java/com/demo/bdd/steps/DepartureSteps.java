package com.demo.bdd.steps;

import com.demo.bdd.BlazeMeterFeatureTest;
import cucumber.api.java.en.When;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class DepartureSteps extends BlazeMeterFeatureTest {
    private static final Logger LOGGER = getLogger(DepartureSteps.class);

    @When("^User gets one departure by id (\\d+)$")
    public void userGetsOneDepartureById(int id) throws Throwable {
        LOGGER.info("When - User gets one departure by id [{}]", id);
    }
}
