package com.example.cloudservice.service;

import com.example.cloudservice.exceptions.InvalidTokenException;
import com.example.cloudservice.model.AuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.cloudservice.exceptions.MessageConstant.TOKEN_INVALID;
import static com.example.cloudservice.exceptions.MessageConstant.TOKEN_PREFIX;

@Service
@RequiredArgsConstructor
public class CheckTokenServiceImpl implements CheckTokenService {

    private final AuthToken token;

    @Override
    public void testToken(String authToken) {
        if (!authToken.equals(TOKEN_PREFIX + token.getAuthToken())) {
            throw new InvalidTokenException(TOKEN_INVALID);
        }
    }
}