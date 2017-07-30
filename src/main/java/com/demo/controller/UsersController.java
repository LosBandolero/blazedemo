package com.demo.controller;

import com.demo.domain.Users;
import com.demo.repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.demo.constant.Paths.USERS;
import static com.demo.constant.Paths.VERSION;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = VERSION + USERS)
@Api(value = VERSION + USERS)
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @ApiOperation(value = "Get all users")
    @RequestMapping(value = "all", method = GET)
    @ResponseBody
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @ApiOperation(value = "Get users by ID")
    @RequestMapping(value = "{id}", method = GET)
    @ResponseBody
    public Users getUsersById(@PathVariable(value = "id") int id) {
        return usersRepository.findAllById(id);
    }

    @ApiOperation(value = "Delete users by ID")
    @RequestMapping(value = "{id}", method = DELETE)
    @ResponseBody
    public void removeUsersById(@PathVariable(value = "id") int id) {
        usersRepository.deleteById(id);
    }

    @ApiOperation(value = "Add user data")
    @RequestMapping(method = POST)
    @ResponseBody
    public Users setUserData(@RequestBody Map<String, String> user) throws IOException {
        ObjectMapper om = new ObjectMapper();
        Users u = om.readValue(new ObjectMapper().writeValueAsString(user), Users.class);
        usersRepository.save(u);
        return u;
    }
}