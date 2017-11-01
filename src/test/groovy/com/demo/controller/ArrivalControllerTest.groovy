package com.demo.controller

import com.demo.BlazeMeterApi
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static com.demo.constant.Paths.ARRIVAL
import static com.demo.constant.Paths.VERSION
import static io.restassured.http.ContentType.JSON

@SpringBootTest(
        classes = BlazeMeterApi.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles(value = "test")
@ContextConfiguration
class ArrivalControllerTest extends Specification {

    RESTClient restClient = new RESTClient("http://localhost:16666", JSON)

    def "Check Arrivals controller"() {
        restClient.auth.basic 'blaze', 'Q1w2e3r4'

        when: "get all arrivals"
        def response = restClient.get(
                path: VERSION + ARRIVAL + 'all',
                requestContentType: JSON
        )

        then: "Status is 200"
        response.status == 200

        and: "Body contains proper values"
        assert response.data[0].id == 1
        assert response.data[0].city == 'Buenos Aires'
        assert response.data.size == 7
    }
}