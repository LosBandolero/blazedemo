package com.demo.unit.controller;

import com.demo.controller.FlightController;
import com.demo.domain.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.demo.constant.Paths.FLIGHT;
import static com.demo.constant.Paths.VERSION;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FlightController flightController;

    @Test
    public void getAllFlights() throws Exception {
        Flight flight = createFlight();

        List<Flight> flights = singletonList(flight);

        given(flightController.getAllFlights()).willReturn(flights);

        mvc.perform(get(VERSION + FLIGHT + "all")
                .with(user("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].airline", is(flight.getAirline())));
    }

    @Test
    public void getFlightById() throws Exception {
        Flight flight = createFlight();

        given(flightController.getFlightById(flight.getId())).willReturn(flight);

        mvc.perform(get(VERSION + FLIGHT + flight.getId())
                .with(user("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("airline", is(flight.getAirline())));
    }

    private Flight createFlight() {
        Flight flight = new Flight();
        flight.setAirline("Virgin");
        flight.setDepartureTime("20:00:00");
        flight.setArrivalTime("23:20:00");
        flight.setNumber(432);
        flight.setPrice("$3000");

        return flight;
    }

}