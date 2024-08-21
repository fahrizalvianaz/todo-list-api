package com.example.demo.service;


import com.example.demo.dto.register.RegisterRequestDto;
import com.example.demo.dto.login.LoginRequestDto;
import com.example.demo.dto.login.LoginResponseDto;
import com.example.demo.model.Customers;

public interface CustomerService {
    String register(RegisterRequestDto registerRequestDto);
    LoginResponseDto login(LoginRequestDto loginRequestDto);





}
