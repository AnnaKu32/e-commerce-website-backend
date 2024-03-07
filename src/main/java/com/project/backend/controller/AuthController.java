package com.project.backend.controller;

import com.project.backend.model.repository.RoleRepository;
import com.project.backend.model.repository.UserRepository;
import com.project.backend.payload.request.LoginRequest;
import com.project.backend.payload.request.SignupRequest;
import com.project.backend.payload.response.MessageResponse;
import com.project.backend.security.jwt.JwtUtil;
import com.project.backend.security.service.impl.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authReq);

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();

        return ResponseEntity.ok(new MessageResponse(
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                HttpStatus.valueOf(200),
                "User logged in successfully"));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignupRequest signupRequest) {}

}