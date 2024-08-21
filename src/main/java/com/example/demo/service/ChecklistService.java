package com.example.demo.service;

import com.example.demo.dto.checklist.ChecklistResponseDto;
import com.example.demo.dto.checklist.CreateChecklistReqDto;

import java.util.List;

public interface ChecklistService {

    List<ChecklistResponseDto> getChecklist(Long userId);

    String createChecklist(Long userId, CreateChecklistReqDto name);

    String deleteChecklist(Long userId, Long idItemChecklist);
}
