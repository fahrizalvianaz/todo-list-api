package com.example.demo.controller;


import com.example.demo.dto.base.BaseResponse;
import com.example.demo.dto.login.LoginRequestDto;
import com.example.demo.dto.register.RegisterRequestDto;
import com.example.demo.service.CustomerService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/"})
public class AuthController {
    @Autowired
    CustomerService customerService;

    @Autowired
    JwtUtil jwtUtil;

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @PostMapping(value = {"register", "register/"})
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto){
        return ResponseEntity.ok(BaseResponse.success(null, customerService.register(registerRequestDto)));
    }

    @PostMapping(value = {"login", "login/"})
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
         return ResponseEntity.ok(BaseResponse.success(customerService.login(loginRequestDto), "Login sukses"));
    }

}
