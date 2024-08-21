package com.example.demo.controller;


import com.example.demo.dto.checklist.CreateChecklistReqDto;
import com.example.demo.dto.base.BaseResponse;
import com.example.demo.service.ChecklistService;
import com.example.demo.service.CustomerService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = {"checklist", "checklist/"})
    public ResponseEntity<?> createCheckList(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody CreateChecklistReqDto createChecklistReqDto){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(null, checklistService.createChecklist(userId, createChecklistReqDto)));
    }

    @DeleteMapping(value = {"checklist/{idChecklist}"})
    public ResponseEntity<?> deleteCheckList(
            @RequestHeader(name = "Authorization") String token,
            @PathVariable Long idChecklist){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(null, checklistService.deleteChecklist(userId, idChecklist)));
    }
}
