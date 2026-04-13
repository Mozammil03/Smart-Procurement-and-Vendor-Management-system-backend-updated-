package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder create(Long vendorId, Long requisitionId, Double totalAmount);
    List<PurchaseOrder> all();
    List<PurchaseOrder> getByVendorId(Long vendorId);
    Optional<PurchaseOrder> getById(Long id);
    List<PurchaseOrder> getByRequisition(Long id);
    void delete(Long id);
    List<PurchaseOrder> search(String keyword);
}
