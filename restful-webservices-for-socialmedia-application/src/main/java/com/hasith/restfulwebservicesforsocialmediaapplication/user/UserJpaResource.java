package com.hasith.restfulwebservicesforsocialmediaapplication.user;

import com.hasith.restfulwebservicesforsocialmediaapplication.post.Post;
import com.hasith.restfulwebservicesforsocialmediaapplication.post.PostRepository;
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
    private final PostRepository postRepository;

    public UserJpaResource( UserRepository userRepository,PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
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
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getPostsForUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException("id : "+id);
        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody  Post post){
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isEmpty()) throw new UserNotFoundException("id : "+id);
        post.setUser(currentUser.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
