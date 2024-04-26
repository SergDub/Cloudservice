package com.example.cloudservice.service;

import com.example.cloudservice.model.AuthRequest;
import com.example.cloudservice.model.AuthResponse;

public interface UserService {

    AuthResponse loginUser(AuthRequest authRequest);

    void logoutUser(String authToken);
}