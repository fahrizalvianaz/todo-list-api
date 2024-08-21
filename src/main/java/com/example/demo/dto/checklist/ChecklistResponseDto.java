package com.example.demo.dto.checklist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChecklistResponseDto {
    private Long idChecklist;
    private String name;
}
