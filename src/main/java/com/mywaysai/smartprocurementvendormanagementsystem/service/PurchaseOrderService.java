package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder create(Long vendorId, Long requisitionId);
    List<PurchaseOrder> all();

    Optional<PurchaseOrder> getById(Long id);

    List<PurchaseOrder> getByRequisition(Long id);
}
