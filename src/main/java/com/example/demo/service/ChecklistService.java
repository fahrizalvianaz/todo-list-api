package com.example.demo.service;

import com.example.demo.dto.Checklist.ChecklistResponseDto;

import java.util.List;

public interface ChecklistService {

    List<ChecklistResponseDto> getChecklist(Long userId);
}
