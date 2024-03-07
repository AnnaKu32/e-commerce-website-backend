package com.project.backend.payload.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MessageResponse {

    private long id;

    private String username;

    private String email;

    private HttpStatus httpStatus;

    private String message;

    public MessageResponse(long id, String username, String email, HttpStatus httpStatus, String message) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
