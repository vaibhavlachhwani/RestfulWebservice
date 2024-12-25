package com.vaibhav.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
