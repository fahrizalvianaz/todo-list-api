package com.example.demo.repository;

import com.example.demo.model.Customers;
import com.example.demo.model.ItemChecklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemChecklistRepository extends JpaRepository<ItemChecklist, Long> {
    List<ItemChecklist> findByCustomers(Customers customers);

    Optional<ItemChecklist> findByIdItemChecklistAndCustomers(Long id, Customers customers);

}
