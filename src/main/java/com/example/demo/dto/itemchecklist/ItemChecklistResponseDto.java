package com.example.demo.dto.itemchecklist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemChecklistResponseDto {
    private Long idItemChecklist;
    private String itemName;
}
