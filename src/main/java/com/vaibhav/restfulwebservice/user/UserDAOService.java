package com.vaibhav.restfulwebservice.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAOService {

//    private static final List<User> users = new ArrayList<>();
//    private static int userCount = 100;
//
//    static {
//        users.add(new User(++userCount, "jane", LocalDate.of(2000, 10, 25)));
//        users.add(new User(++userCount, "jonah", LocalDate.of(2004, 10, 30)));
//        users.add(new User(++userCount, "dina", LocalDate.of(1998, 12, 25)));
//        users.add(new User(++userCount, "amy", LocalDate.of(1999, 1, 25)));
//        users.add(new User(++userCount, "jake", LocalDate.of(2004, 4, 28)));
//    }

    private final UserRepository userRepository;

    public UserDAOService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findOne(int id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
