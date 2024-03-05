package com.project.backend.controller;

import com.project.backend.model.dao.User;
import com.project.backend.model.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repository;

    AuthController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    User loginUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PostMapping("/signup")
    User registerUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }


}