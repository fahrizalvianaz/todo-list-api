package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String username;

    private String password;
}
