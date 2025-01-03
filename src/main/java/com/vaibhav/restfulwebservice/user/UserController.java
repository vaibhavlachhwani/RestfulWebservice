package com.vaibhav.restfulwebservice.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
    public EntityModel<User> retrieveUser(@PathVariable int id) throws UserNotFoundException {
        User user = userDAOService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id : " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder links = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(links.withRel("all-users"));

        return entityModel;
    }

    // POST /api/users
    @PostMapping("")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDAOService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userDAOService.deleteUserById(id);
    }
}
