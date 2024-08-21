package com.example.demo.mapper;

import com.example.demo.dto.Checklist.ChecklistResponseDto;
import com.example.demo.model.ItemChecklist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ChecklistMapper {

    public List<ChecklistResponseDto> toChecklistResponse(List<ItemChecklist> itemChecklists) {
        return itemChecklists.stream()
                .map(this::mapToChecklistResponseDto)
                .collect(Collectors.toList());
    }


    private ChecklistResponseDto mapToChecklistResponseDto(ItemChecklist itemChecklist) {

        return ChecklistResponseDto.builder()
                .idItemChecklist(itemChecklist.getIdItemChecklist())
                .name(itemChecklist.getName())
                .build();
    }
}
