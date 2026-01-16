package com.example.student_management.controller;

import com.example.student_management.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {

        userService.login(body.get("username"), body.get("password"));
        return "Login Successful";
    }

}
