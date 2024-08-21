package com.example.demo.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpiredTokenResponse {
    private int status;
    private String message;
    private String expiredAt;
    private String currentTime;
    private String path;
}
