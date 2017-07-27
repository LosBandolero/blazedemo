package com.demo.bdd.steps;

import com.demo.bdd.BlazeMeterFeatureTest;
import cucumber.api.java.en.When;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class UserSteps extends BlazeMeterFeatureTest {
    private static final Logger LOGGER = getLogger(UserSteps.class);

    @When("^User gets one user by id (\\d+)$")
    public void userGetsOneUserById(int id) throws Throwable {
        LOGGER.info("When - User gets one user by id [{}]", id);
    }
}
