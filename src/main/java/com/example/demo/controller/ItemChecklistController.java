package com.example.demo.controller;

import com.example.demo.dto.checklist.CreateChecklistReqDto;
import com.example.demo.dto.base.BaseResponse;
import com.example.demo.dto.checklist.CreateItemChecklistReqDto;
import com.example.demo.service.ChecklistService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ItemChecklistService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/checklist"})
public class ItemChecklistController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ItemChecklistService itemChecklistService;

    @Autowired
    JwtUtil jwtUtil;


    @GetMapping(value = {"{checklistId}/item"})
    public ResponseEntity<?> getItemCheckList(@RequestHeader(name = "Authorization") String token,
                                              @PathVariable Long checklistId){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(itemChecklistService.getItemChecklist(userId, checklistId), "sukses"));
    }

    @PostMapping(value = {"{checklistId}/item"})
    public ResponseEntity<?> createCheckList(
            @RequestHeader(name = "Authorization") String token,
            @PathVariable Long checklistId,
            @RequestBody CreateItemChecklistReqDto createItemChecklistReqDto){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(null, itemChecklistService.createItemChecklist(userId, checklistId, createItemChecklistReqDto)));
    }

    @GetMapping(value = {"{checklistId}/item/{checklistItemId}"})
    public ResponseEntity<?> getItemCheckListbyId(
            @RequestHeader(name = "Authorization") String token,
            @PathVariable Long checklistId,
            @PathVariable Long checklistItemId){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(itemChecklistService.getItemChecklistById(userId, checklistId, checklistItemId), " sukses" ));
    }

    @PutMapping(value = {"{checklistId}/item/{checklistItemId}"})
    public ResponseEntity<?> updateItemCheckList(
            @RequestHeader(name = "Authorization") String token,
            @PathVariable Long checklistId,
            @PathVariable Long checklistItemId){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(itemChecklistService.updateItemChecklist(userId, checklistId, checklistItemId), " sukses update status" ));
    }

    @DeleteMapping(value = {"{checklistId}/item/{checklistItemId}"})
    public ResponseEntity<?> deleteItemCheckList(
            @RequestHeader(name = "Authorization") String token,
            @PathVariable Long checklistId,
            @PathVariable Long checklistItemId){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(itemChecklistService.deleteItemChecklist(userId, checklistId, checklistItemId), " sukses hapus" ));
    }

    @PutMapping(value = {"{checklistId}/item/rename/{checklistItemId}"})
    public ResponseEntity<?> renameItemCheckList(
            @RequestHeader(name = "Authorization") String token,
            @PathVariable Long checklistId,
            @PathVariable Long checklistItemId,
            @RequestBody CreateItemChecklistReqDto createItemChecklistReqDto){
        String jwt = token.substring("Bearer ".length());
        Long userId = jwtUtil.getId(jwt);
        return ResponseEntity.ok(BaseResponse.success(itemChecklistService.renameItemChecklist(userId, checklistId, checklistItemId, createItemChecklistReqDto), " sukses update status" ));
    }
}
