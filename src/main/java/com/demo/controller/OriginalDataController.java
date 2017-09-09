package com.demo.controller;

import com.demo.domain.OriginalData;
import com.demo.repository.OriginalDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

import static com.demo.constant.Paths.OD;
import static com.demo.constant.Paths.VERSION;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = VERSION + OD)
@Api(value = VERSION + OD)
public class OriginalDataController {

    @Autowired
    private OriginalDataRepository odRepository;

    @ApiOperation(value = "Persiste user data")
    @RequestMapping(method = POST)
    @ResponseBody
    public void setUserData(@RequestBody Map<String, String> originalData) throws IOException {
        ObjectMapper om = new ObjectMapper();
        for (int i = 0; i < 1500; i++) {
            OriginalData od = new OriginalData();
            od.setData(om.writeValueAsString(originalData));
            odRepository.save(od);
        }
    }
}
