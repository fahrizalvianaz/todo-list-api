package com.example.demo.dto.register;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequestDto {

    private String email;
    private String password;
    private String username;


}