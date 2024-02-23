package com.hasith.restfulwebservicesforsocialmediaapplication.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    private final UserDaoService userDaoService;
    @Autowired
    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping( "/users")
    public List<User> retrieveALlUsers(){
        return userDaoService.findAL();
    }
}
