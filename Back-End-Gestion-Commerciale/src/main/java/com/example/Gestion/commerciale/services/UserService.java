package com.example.Gestion.commerciale.services;

import com.example.Gestion.commerciale.configurations.SecurityConfig;
import com.example.Gestion.commerciale.models.User;
import com.example.Gestion.commerciale.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SecurityConfig securityConfig;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && securityConfig.passwordEncoder().matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }


}
