package com.demo.bdd;

import com.demo.BlazeMeterApi;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest(
        classes = BlazeMeterApi.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class BlazeMeterFeatureTest {
}
