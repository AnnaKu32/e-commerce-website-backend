package com.project.backend.controller;

import com.project.backend.exception.UserNotFoundException;
import com.project.backend.model.dao.User;
import com.project.backend.model.dto.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repository;

    AuthController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/signup")
    User logiNUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PostMapping("/signin")
    User newEmployee(@RequestBody User newUser) {
        return repository.save(newUser);
    }


}