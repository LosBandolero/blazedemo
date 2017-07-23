package com.demo.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.demo.bdd.steps"},
        features = {"classpath:bdd/features"}
)
@ActiveProfiles(value = "test")
public class BddCoverage {
}
