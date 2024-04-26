package com.example.cloudservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_tableSequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_tableSequence")
    @Column(name = "id")
    private Long Id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}