package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;

import java.util.List;


public interface RequisitionRepository  extends JpaRepository<Requisition,Long>{
    List<Requisition> findByStatus(String status);

}
