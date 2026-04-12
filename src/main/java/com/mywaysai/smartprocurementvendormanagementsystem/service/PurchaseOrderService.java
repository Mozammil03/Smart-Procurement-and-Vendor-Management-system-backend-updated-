package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder create(Long vendorId, Long requisitionId, Double totalAmount);
    List<PurchaseOrder> all();
    Optional<PurchaseOrder> getById(Long id);
    List<PurchaseOrder> getByRequisition(Long id);
    void delete(Long id);
    List<PurchaseOrder> search(String keyword);
=======

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder create(Long vendorId, Long requisitionId);
    List<PurchaseOrder> all();

    Optional<PurchaseOrder> getById(Long id);

    List<PurchaseOrder> getByRequisition(Long id);
>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
}
