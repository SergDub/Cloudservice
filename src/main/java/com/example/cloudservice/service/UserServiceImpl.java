package com.example.cloudservice.service;

import com.example.cloudservice.exceptions.LoginException;
import com.example.cloudservice.model.AuthRequest;
import com.example.cloudservice.model.AuthResponse;
import com.example.cloudservice.model.AuthToken;
import com.example.cloudservice.model.entity.UserEntity;
import com.example.cloudservice.repository.UserRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.cloudservice.exceptions.MessageConstant.*;
import static java.util.Objects.isNull;

@Data
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final AuthToken authToken;
    private final UserRepository userRepository;

    @Override
    public AuthResponse loginUser(AuthRequest authRequest) {
        if (isNull(authRequest.getLogin()) && isNull(authRequest.getPassword())) {
            throw new LoginException(LOGIN_NON_VALID_VALUE);
        }
        UserEntity userEntity = userRepository.getUsersByEmail(authRequest.getLogin()).orElseThrow(()
                -> new LoginException(LOGIN_NOT_FOUND_USER));
        if (!authRequest.getPassword().equals(userEntity.getPassword())) {
            throw new LoginException(LOGIN_NOT_VALID_PASSWORD);
        }
        return new AuthResponse(authToken.getAuthToken());
    }

    @Override
    public void logoutUser(String authToken) {
        userRepository.getUsersByEmail(authToken);
        log.info("User logout");
        userRepository.removeAllByEmail(authToken);
    }
}