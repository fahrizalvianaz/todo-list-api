package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Entity
@Data
@Table(name = "checklist", schema = "public")
@EqualsAndHashCode(callSuper = true)
public class Checklist extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    private Long idChecklist;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "checklist")
    private List<ItemChecklist> itemChecklists;
}
