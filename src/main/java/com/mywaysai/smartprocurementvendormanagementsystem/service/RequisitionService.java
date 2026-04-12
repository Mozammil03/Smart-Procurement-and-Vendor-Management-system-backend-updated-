package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;

public interface RequisitionService {
    Requisition create(Requisition r);
    List<Requisition> list();

    List<Requisition> findAll();

    Optional<Requisition> getById(Long id);

    Requisition update(Long id, Requisition r);

    void delete(Long id);

    List<Requisition> getByStatus(String pending);

    
}
