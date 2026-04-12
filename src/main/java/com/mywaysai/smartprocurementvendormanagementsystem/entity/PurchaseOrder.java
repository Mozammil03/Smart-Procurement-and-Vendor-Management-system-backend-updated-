package com.mywaysai.smartprocurementvendormanagementsystem.entity;

import java.time.LocalDate;
<<<<<<< HEAD
=======

>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
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
<<<<<<< HEAD
    private Double totalAmount;
=======
>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af

    @ManyToOne
    private Vendor vendor;

<<<<<<< HEAD
=======

















    // ADD THIS
>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
    @ManyToOne
    @JoinColumn(name = "requisition_id")
    private Requisition requisition;
}
<<<<<<< HEAD
=======

>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
