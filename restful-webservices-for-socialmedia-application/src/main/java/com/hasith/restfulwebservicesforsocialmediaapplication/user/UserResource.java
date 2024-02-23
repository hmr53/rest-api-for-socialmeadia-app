package com.hasith.restfulwebservicesforsocialmediaapplication.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    private final UserDaoService userDaoService;

    @Autowired
    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveALlUsers() {
        return userDaoService.findAL();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable String id) {
        return userDaoService.findById(id);
    }
}
