package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.PageImpl;

@Entity
@Data
@Table(name = "itemChecklist", schema = "public")
@EqualsAndHashCode(callSuper = true)
public class ItemChecklist extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_checklist_id")
    private Long idItemChecklist;

    private String itemName;

    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checklist_id")
    private Checklist checklist;


}
