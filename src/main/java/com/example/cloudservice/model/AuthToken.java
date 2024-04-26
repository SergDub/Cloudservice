package com.example.cloudservice.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AuthToken {

    private String authToken;
}