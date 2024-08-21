package com.example.demo.service.impl;

import com.example.demo.dto.Checklist.ChecklistResponseDto;
import com.example.demo.mapper.ChecklistMapper;
import com.example.demo.model.Customers;
import com.example.demo.model.ItemChecklist;
import com.example.demo.repository.ChecklistRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChecklistServiceImpl implements ChecklistService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ChecklistRepository checklistRepository;

    @Autowired
    ChecklistMapper checklistMapper;
    @Override
    public List<ChecklistResponseDto> getChecklist(Long userId) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        List<ItemChecklist> itemChecklist = checklistRepository.findByCustomers(customers);

        return checklistMapper.toChecklistResponse(itemChecklist);
    }
}
