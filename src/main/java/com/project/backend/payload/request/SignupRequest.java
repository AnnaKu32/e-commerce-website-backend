package com.project.backend.payload.request;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;

@Getter
@Setter
public class SignupRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 20)
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    public SignupRequest(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}


