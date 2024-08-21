package com.example.demo.mapper;

import com.example.demo.dto.checklist.ChecklistResponseDto;
import com.example.demo.model.Checklist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ChecklistMapper {

    public List<ChecklistResponseDto> toChecklistResponse(List<Checklist> itemChecklists) {
        return itemChecklists.stream()
                .map(this::mapToChecklistResponseDto)
                .collect(Collectors.toList());
    }


    private ChecklistResponseDto mapToChecklistResponseDto(Checklist checklist) {

        return ChecklistResponseDto.builder()
                .idChecklist(checklist.getIdChecklist())
                .name(checklist.getName())
                .build();
    }
}
