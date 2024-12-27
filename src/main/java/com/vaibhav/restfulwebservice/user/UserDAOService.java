package com.vaibhav.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOService {

    private static final List<User> users = new ArrayList<>();
    private static int userCount = 100;

    static {
        users.add(new User(++userCount, "jane", LocalDate.of(2000, 10, 25)));
        users.add(new User(++userCount, "jonah", LocalDate.of(2004, 10, 30)));
        users.add(new User(++userCount, "dina", LocalDate.of(1998, 12, 25)));
        users.add(new User(++userCount, "amy", LocalDate.of(1999, 1, 25)));
        users.add(new User(++userCount, "jake", LocalDate.of(2004, 4, 28)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteUserById(int id) {
        users.removeIf(
                user -> user.getId() == id
        );
    }
}
