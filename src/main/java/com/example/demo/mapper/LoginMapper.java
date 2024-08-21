package com.example.demo.mapper;

import com.example.demo.dto.login.LoginResponseDto;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public LoginResponseDto toLoginResponse(String accessToken) {
        return LoginResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }
}
