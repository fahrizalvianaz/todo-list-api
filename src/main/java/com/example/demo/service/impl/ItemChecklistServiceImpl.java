package com.example.demo.service.impl;


import com.example.demo.dto.checklist.ChecklistResponseDto;
import com.example.demo.dto.checklist.CreateItemChecklistReqDto;
import com.example.demo.dto.itemchecklist.ItemChecklistResponseDto;
import com.example.demo.mapper.ChecklistMapper;
import com.example.demo.mapper.ItemChecklistMapper;
import com.example.demo.model.Checklist;
import com.example.demo.model.Customers;
import com.example.demo.model.ItemChecklist;
import com.example.demo.repository.ChecklistRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ItemChecklistRepository;
import com.example.demo.service.ItemChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ItemChecklistServiceImpl implements ItemChecklistService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ChecklistRepository checklistRepository;


    @Autowired
    ItemChecklistRepository itemChecklistRepository;

    @Autowired
    ItemChecklistMapper checklistMapper;
    @Override
    public List<ItemChecklistResponseDto> getItemChecklist(Long userId, Long idChecklist) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Checklist checklist = checklistRepository.findByIdChecklistAndCustomers(idChecklist, customers)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Checklist not found"));
        List<ItemChecklist> itemChecklists = itemChecklistRepository.findByCustomersAndChecklist(customers, checklist);

        return checklistMapper.toChecklistResponse(itemChecklists);

    }

    @Override
    public String createItemChecklist(Long userId, Long idChecklist, CreateItemChecklistReqDto name) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Checklist checklist = checklistRepository.findByIdChecklistAndCustomers(idChecklist, customers)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Checklist not found"));
        ItemChecklist itemChecklist = new ItemChecklist();
        itemChecklist.setItemName(name.getItemName());
        itemChecklist.setCustomers(customers);
        itemChecklist.setChecklist(checklist);
        itemChecklist.setStatus(false);
        itemChecklistRepository.save(itemChecklist);
        return "Sukses menambahkan data";
    }

    @Override
    public ItemChecklistResponseDto getItemChecklistById(Long userId, Long idChecklist, Long idItemChecklist) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Checklist checklist = checklistRepository.findByIdChecklistAndCustomers(idChecklist, customers)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Checklist not found"));
        ItemChecklist itemChecklist = itemChecklistRepository.findByIdItemChecklistAndCustomersAndChecklist(idItemChecklist, customers, checklist);
        return checklistMapper.toChecklistResponseDto(itemChecklist);
    }

    @Override
    public ItemChecklistResponseDto updateItemChecklist(Long userId, Long idChecklist, Long idItemChecklist) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Checklist checklist = checklistRepository.findByIdChecklistAndCustomers(idChecklist, customers)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Checklist not found"));
        ItemChecklist itemChecklist = itemChecklistRepository.findByIdItemChecklistAndCustomersAndChecklist(idItemChecklist, customers, checklist);
        itemChecklist.setStatus(!itemChecklist.getStatus());
        itemChecklistRepository.save(itemChecklist);
        return checklistMapper.toChecklistResponseDto(itemChecklist);
    }

    @Override
    public ItemChecklistResponseDto deleteItemChecklist(Long userId, Long idChecklist, Long idItemChecklist) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Checklist checklist = checklistRepository.findByIdChecklistAndCustomers(idChecklist, customers)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Checklist not found"));
        ItemChecklist itemChecklist = itemChecklistRepository.findByIdItemChecklistAndCustomersAndChecklist(idItemChecklist, customers, checklist);
        itemChecklistRepository.delete(itemChecklist);
        return checklistMapper.toChecklistResponseDto(itemChecklist);
    }

    @Override
    public ItemChecklistResponseDto renameItemChecklist(Long userId, Long idChecklist, Long idItemChecklist, CreateItemChecklistReqDto name) {
        Customers customers = customerRepository.findById(userId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Checklist checklist = checklistRepository.findByIdChecklistAndCustomers(idChecklist, customers)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Checklist not found"));
        ItemChecklist itemChecklist = itemChecklistRepository.findByIdItemChecklistAndCustomersAndChecklist(idItemChecklist, customers, checklist);
        itemChecklist.setItemName(name.getItemName());
        ItemChecklist iteSaved = itemChecklistRepository.save(itemChecklist);
        return checklistMapper.toChecklistResponseDto(iteSaved);
    }
}
