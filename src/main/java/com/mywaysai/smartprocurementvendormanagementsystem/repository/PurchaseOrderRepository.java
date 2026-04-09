package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;

import java.util.List;


public interface PurchaseOrderRepository  extends JpaRepository<PurchaseOrder,Long>{
    List<PurchaseOrder> findByRequisitionId(Long requisitionId);
}