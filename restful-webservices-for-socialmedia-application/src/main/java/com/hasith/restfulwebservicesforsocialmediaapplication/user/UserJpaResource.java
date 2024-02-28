package com.hasith.restfulwebservicesforsocialmediaapplication.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {
    private final  UserRepository userRepository;

    public UserJpaResource( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveALlUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> retrieveUser(@PathVariable String id) {
        Optional<User> user =  userRepository.findById(Integer.parseInt(id));

        if (user.isEmpty())
            throw  new UserNotFoundException("Id : "+id);

        return user;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid  @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable String id) {
        System.out.println("Delete Requested");
        userRepository.deleteById(Integer.parseInt(id));
    }
}
