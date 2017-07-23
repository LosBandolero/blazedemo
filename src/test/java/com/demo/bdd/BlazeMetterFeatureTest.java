package com.demo.bdd;

import com.demo.BlazeMetterApi;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest(
        classes = BlazeMetterApi.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class BlazeMetterFeatureTest {
}
