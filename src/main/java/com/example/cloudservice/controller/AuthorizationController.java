package com.example.cloudservice.controller;

import com.example.cloudservice.exceptions.MessageConstant;
import com.example.cloudservice.model.AuthRequest;
import com.example.cloudservice.model.AuthResponse;
import com.example.cloudservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.cloudservice.exceptions.MessageConstant.LOGIN;
import static com.example.cloudservice.exceptions.MessageConstant.LOGOUT;

@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final UserService userService;

    @PostMapping(value = LOGIN)
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        return new ResponseEntity(userService.loginUser(authRequest), HttpStatus.OK);
    }

    @PostMapping(LOGOUT)
    public ResponseEntity<?> logout(@RequestHeader(value = "auth-token", required = false) String authToken) {
        userService.logoutUser(authToken);
        return ResponseEntity.status(HttpStatus.OK)
                .body(MessageConstant.LOGOUT_USER);
    }
}