package com.example.cloudservice.token_scheduler;

import com.example.cloudservice.model.AuthToken;
import com.example.cloudservice.security.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
public class TokenScheduler {

    private final AuthToken authToken;

    private final JwtTokenUtils jwtTokenUtils;

    @Scheduled(fixedDelay = 3600000)
    public void updateToken() {
        log.info("Токен сгенерирован " + LocalDateTime.now());
        authToken.setAuthToken(jwtTokenUtils.generateToken());
    }
}