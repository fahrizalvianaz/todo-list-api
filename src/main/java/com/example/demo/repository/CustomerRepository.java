package com.example.demo.repository;

import com.example.demo.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    Optional<Customers> findByUsername(String username);

    Optional<Customers> findByEmail(String username);

}
