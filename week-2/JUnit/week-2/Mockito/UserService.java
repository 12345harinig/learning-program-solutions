package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    // Constructor injection for UserRepository
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    public String getUserName(int id) {
        return userRepo.findById(id)
                       .map(User::getName)
                       .orElse("Unknown");
    }


    // ✅ Method used in your test
//    public String getUserName(int id) {
//        Optional<User> user = userRepo.findById(id);
//        return user.map(User::getName).orElse("Unknown");
//    }

    // Additional useful methods (optional)
    

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
