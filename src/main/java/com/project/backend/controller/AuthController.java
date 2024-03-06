package com.project.backend.controller;

import com.project.backend.model.repository.UserRepository;
import com.project.backend.payload.request.LoginRequest;
import com.project.backend.payload.request.SignupRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/signin")
    public ResponseEntity<?> signInUser(@Valid @RequestBody LoginRequest loginRequest) {}

    @PostMapping("/signup")
    public ResponseEntity<?> signInUser(@Valid @RequestBody SignupRequest signupRequest) {}

}