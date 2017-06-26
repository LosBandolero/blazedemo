package com.demo.controller;

import com.demo.domain.Flight;
import com.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.demo.constant.Paths.FLIGHT;
import static com.demo.constant.Paths.VERSION;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = VERSION + FLIGHT)
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(value = "all", method = GET)
    @ResponseBody
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = GET)
    @ResponseBody
    public Flight getFlightById(@PathVariable(value = "id") int id) {
        return flightRepository.findAllById(id);
    }

    @RequestMapping(value = "search", method = POST)
    @ResponseBody
    public Flight getAllFlightFor(@RequestBody Map<String, String> flightFromTo) {
        return flightRepository.findAllById(1);
    }
}
