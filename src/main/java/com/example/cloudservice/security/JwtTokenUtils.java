package com.example.cloudservice.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Data
@Service
@NoArgsConstructor
public class JwtTokenUtils {

    public String generateToken() {
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }
}