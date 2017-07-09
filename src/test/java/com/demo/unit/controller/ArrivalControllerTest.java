package com.demo.unit.controller;

import com.demo.controller.ArrivalController;
import com.demo.domain.Arrival;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.demo.constant.Paths.ARRIVAL;
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
@WebMvcTest(ArrivalController.class)
public class ArrivalControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArrivalController arrivalController;

    @Test
    public void getArrivals() throws Exception {
        Arrival arrival = new Arrival();
        arrival.setCity("Yerevan");

        List<Arrival> allArrivals = singletonList(arrival);

        given(arrivalController.getAllArrivals()).willReturn(allArrivals);

        mvc.perform(get(VERSION + ARRIVAL + "all")
                .with(user("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(arrival.getCity())));
    }

    @Test
    public void getArrivalsById() throws Exception {
        Arrival arrival = new Arrival();
        arrival.setCity("Yerevan");

        given(arrivalController.getArrivalById(arrival.getId())).willReturn(arrival);

        mvc.perform(get(VERSION + ARRIVAL + arrival.getId())
                .with(user("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("city", is(arrival.getCity())));
    }
}