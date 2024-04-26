package com.example.cloudservice.repository;

import com.example.cloudservice.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> getUsersByEmail(String email);

    void removeAllByEmail(String email);
}