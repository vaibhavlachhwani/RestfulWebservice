package com.vaibhav.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(100, "jane", LocalDate.of(2000, 10, 25)));
        users.add(new User(101, "jonah", LocalDate.of(2004, 10, 30)));
        users.add(new User(102, "dina", LocalDate.of(1998, 12, 25)));
        users.add(new User(103, "amy", LocalDate.of(1999, 1, 25)));
        users.add(new User(104, "chey", LocalDate.of(2004, 4, 28)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        User user = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);

        return user;
    }
}
