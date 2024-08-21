package com.example.demo.service;

import com.example.demo.dto.Checklist.ChecklistResponseDto;
import com.example.demo.dto.Checklist.CreateChecklistReqDto;

import java.util.List;

public interface ChecklistService {

    List<ChecklistResponseDto> getChecklist(Long userId);

    String createChecklist(Long userId, CreateChecklistReqDto name);
}
