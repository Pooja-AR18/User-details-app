package com.userapp.service;

import com.userapp.model.User;
import com.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {

        return repo.findAll();
    }

    public void deleteUser(String userId) {

        repo.deleteById(userId);
    }
}
