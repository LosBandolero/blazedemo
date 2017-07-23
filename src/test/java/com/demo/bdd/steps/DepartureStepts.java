package com.demo.bdd.steps;

import com.demo.bdd.BlazeMetterFeatureTest;
import cucumber.api.java.en.When;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class DepartureStepts extends BlazeMetterFeatureTest {
    private static final Logger LOGGER = getLogger(DepartureStepts.class);

    @When("^User gets one departure by id (\\d+)$")
    public void userGetsOneDepartureById(int id) throws Throwable {
        LOGGER.info("When - User gets one departure by id [{}]", id);
    }
}
