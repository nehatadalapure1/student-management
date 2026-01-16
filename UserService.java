package com.example.student_management.service;

import com.example.student_management.exception.InvalidLoginException;
import com.example.student_management.model.User;
import com.example.student_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String rawPassword) {
        User user = userRepository.findByUsername(username);

        if (user == null || !passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new InvalidLoginException("Invalid username or password");
        }

        return "Login Successful";
    }

}
