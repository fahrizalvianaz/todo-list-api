package com.example.demo.service.impl;

import com.example.demo.dto.Checklist.ChecklistResponseDto;
import com.example.demo.dto.Checklist.CreateChecklistReqDto;
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

    @Override
    public String createChecklist(Long userId, CreateChecklistReqDto name) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        ItemChecklist itemChecklist = new ItemChecklist();
        itemChecklist.setName(name.getName());
        itemChecklist.setCustomers(customers);
        checklistRepository.save(itemChecklist);
        return "Sukses menambahkan data";
    }

    @Override
    public String deleteChecklist(Long userId, Long idItemChecklist) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        ItemChecklist itemChecklist = checklistRepository.findByIdItemChecklistAndCustomers(idItemChecklist, customers)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Checklist not found"));
        checklistRepository.delete(itemChecklist);
        return "Suskses menghapus data";
    }
}
