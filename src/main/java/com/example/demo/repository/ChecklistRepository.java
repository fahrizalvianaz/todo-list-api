package com.example.demo.repository;

import com.example.demo.model.Checklist;
import com.example.demo.model.Customers;
import com.example.demo.model.ItemChecklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    List<Checklist> findByCustomers(Customers customers);

    Optional<Checklist> findByIdChecklistAndCustomers(Long id, Customers customers);

}
