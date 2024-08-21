package com.example.demo.dto.Checklist;

import com.example.demo.model.ItemChecklist;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChecklistResponseDto {
    private Long idChecklist;
    private String name;
}
