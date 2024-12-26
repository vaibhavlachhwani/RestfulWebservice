package com.vaibhav.restfulwebservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserDAOService userDAOService;

    public UserController(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }

    // GET /api/users
    @GetMapping("")
    public List<User> retrieveAllUsers() {
        return userDAOService.findAll();
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDAOService.findOne(id);

        if (user == null) {
            return new User();
        }

        return user;
    }

    // POST /api/users
    @PostMapping("")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userDAOService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
