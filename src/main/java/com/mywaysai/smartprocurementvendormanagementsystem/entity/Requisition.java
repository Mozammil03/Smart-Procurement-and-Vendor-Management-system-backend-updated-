package com.mywaysai.smartprocurementvendormanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Requisition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String itemName;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;
    private String status;
//
//    @OneToMany(mappedBy = "requisition", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Approval> approvals;

//
//    @OneToMany(mappedBy = "requisition", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Approval> approvals;
}
