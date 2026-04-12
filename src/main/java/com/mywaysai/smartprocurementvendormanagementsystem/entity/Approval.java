package com.mywaysai.smartprocurementvendormanagementsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String managerName;
    private String decision;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime approvedDate;

   // @OneToOne

    @ManyToOne
    @JoinColumn(name = "requisition_id")
    private Requisition requisition;





















}

