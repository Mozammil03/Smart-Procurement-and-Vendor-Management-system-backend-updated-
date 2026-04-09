package com.mywaysai.smartprocurementvendormanagementsystem.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String poNumber;
    private String status;
    private LocalDate orderDate;

    @ManyToOne
    private Vendor vendor;


















    // ADD THIS
    @ManyToOne
    @JoinColumn(name = "requisition_id")
    private Requisition requisition;
}

