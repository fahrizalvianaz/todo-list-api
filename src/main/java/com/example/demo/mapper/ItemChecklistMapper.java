package com.example.demo.mapper;

import com.example.demo.dto.checklist.ChecklistResponseDto;
import com.example.demo.dto.itemchecklist.ItemChecklistResponseDto;
import com.example.demo.model.Checklist;
import com.example.demo.model.ItemChecklist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ItemChecklistMapper {

    public List<ItemChecklistResponseDto> toChecklistResponse(List<ItemChecklist> itemChecklists) {
        return itemChecklists.stream()
                .map(this::mapToChecklistResponseDto)
                .collect(Collectors.toList());
    }


    private ItemChecklistResponseDto mapToChecklistResponseDto(ItemChecklist checklist) {

        return ItemChecklistResponseDto.builder()
                .idItemChecklist(checklist.getIdItemChecklist())
                .itemName(checklist.getItemName())
                .build();
    }

    public ItemChecklistResponseDto toChecklistResponseDto(ItemChecklist itemChecklist) {
        return ItemChecklistResponseDto.builder()
                .idItemChecklist(itemChecklist.getIdItemChecklist())
                .itemName(itemChecklist.getItemName())
                .build();
    }
}
