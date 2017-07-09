package com.demo.unit.controller;

import com.demo.controller.DepartureController;
import com.demo.domain.Departure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.demo.constant.Paths.DEPARTURE;
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
@WebMvcTest(DepartureController.class)
public class DepartureControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartureController departureController;

    @Test
    public void getAllDepartures() throws Exception {
        Departure departure = new Departure();
        departure.setCity("Yerevan");

        List<Departure> departures = singletonList(departure);

        given(departureController.getAllDepartures()).willReturn(departures);

        mvc.perform(get(VERSION + DEPARTURE + "all")
                .with(user("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(departure.getCity())));
    }

    @Test
    public void getDepartureById() throws Exception {
        Departure departure = new Departure();
        departure.setCity("Yerevan");

        given(departureController.getDepartureById(departure.getId())).willReturn(departure);

        mvc.perform(get(VERSION + DEPARTURE + departure.getId())
                .with(user("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("city", is(departure.getCity())));
    }
}
