package com.example.demo.service;

import com.example.demo.dto.checklist.ChecklistResponseDto;
import com.example.demo.dto.checklist.CreateChecklistReqDto;
import com.example.demo.dto.checklist.CreateItemChecklistReqDto;
import com.example.demo.dto.itemchecklist.ItemChecklistResponseDto;

import java.util.List;

public interface ItemChecklistService {
    List<ItemChecklistResponseDto> getItemChecklist(Long userId, Long idChecklist);

    String createItemChecklist(Long userId, Long idChecklist, CreateItemChecklistReqDto name);

    ItemChecklistResponseDto getItemChecklistById(Long userId, Long idChecklist, Long idItemChecklist);
}
