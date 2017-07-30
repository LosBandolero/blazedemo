package com.demo.controller;

import com.demo.domain.Departure;
import com.demo.repository.DepartureRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.demo.constant.Paths.DEPARTURE;
import static com.demo.constant.Paths.VERSION;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = VERSION + DEPARTURE)
@Api(value = VERSION + DEPARTURE)
public class DepartureController {

    @Autowired
    private DepartureRepository departureRepository;

    @ApiOperation(value = "Get all departures")
    @RequestMapping(value = "all", method = GET)
    @ResponseBody
    public List<Departure> getAllDepartures() {
        return departureRepository.findAll();
    }

    @ApiOperation(value = "Get departures by ID")
    @RequestMapping(value = "{id}", method = GET)
    @ResponseBody
    public Departure getDepartureById(@PathVariable(value = "id") int id) {
        return departureRepository.findAllById(id);
    }
}
