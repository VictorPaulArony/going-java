package com.user.Registration.service;

import org.springframework.stereotype.Service;
import com.user.Registration.model.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public User registerUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public boolean deletUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }

//    public User add(User user) {
//        // save and return user
//    }

}