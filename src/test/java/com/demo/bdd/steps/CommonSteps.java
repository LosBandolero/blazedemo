package com.demo.bdd.steps;

import com.demo.bdd.BlazeMetterFeatureTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class CommonSteps extends BlazeMetterFeatureTest {

    private static final Logger LOGGER = getLogger(CommonSteps.class);

    @Given("^(.+) rest endpoint is up$")
    public void arrivalRestEndpointIsUp(String endpointType) throws Throwable {
        LOGGER.info("Given - [{}] rest endpoint is up", endpointType);
    }

    @Then("^Returned JSON object is not null$")
    public void returnedJSONObjectIsNotNull() {
        LOGGER.info("Then - Returned JSON object is not null");
    }
}
