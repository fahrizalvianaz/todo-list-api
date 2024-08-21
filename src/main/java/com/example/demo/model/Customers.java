package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@Table(name = "customers", schema = "public")
@EqualsAndHashCode(callSuper = true)
public class Customers extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long idCustomers;

    private String username;

    private String password;

    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
    private List<ItemChecklist> itemChecklists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
    private List<Checklist> checklists;

}
