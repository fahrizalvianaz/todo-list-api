package com.example.demo.controller;


import com.example.demo.dto.base.BaseResponse;
import com.example.demo.dto.register.RegisterRequestDto;
import com.example.demo.repository.ChecklistRepository;
import com.example.demo.service.ChecklistService;
import com.example.demo.service.CustomerService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/"})
public class ChecklistController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ChecklistService checklistService;

    @Autowired
    JwtUtil jwtUtil;


    @GetMapping(value = {"checklist", "checklist/"})
    public ResponseEntity<?> checkList(@RequestHeader(name = "Authorization") String token){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(checklistService.getChecklist(userId), "sukses"));
    }
}
