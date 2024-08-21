package com.example.demo.service.impl;
import com.example.demo.dto.register.RegisterRequestDto;
import com.example.demo.dto.login.LoginRequestDto;
import com.example.demo.dto.login.LoginResponseDto;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.Customers;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.util.JwtUtil;
import com.example.demo.util.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    LoginMapper loginMapper;



    //ignore register service
    @Override
    public String register(RegisterRequestDto registerRequestDto) {

        Customers customers = new Customers();
        customers.setUsername(registerRequestDto.getUsername());
        customers.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        customers.setEmail(registerRequestDto.getEmail());
        customerRepository.save(customers);
        return "Sukses Registrasi";
    }




    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Optional<Customers> customer = Optional.ofNullable(customerRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User tidak ditemukan")
        ));
        Customers customers = customer.get();
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), customers.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username atau password yang anda masukkan salah");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication);

        return loginMapper.toLoginResponse(token);

    }



}
