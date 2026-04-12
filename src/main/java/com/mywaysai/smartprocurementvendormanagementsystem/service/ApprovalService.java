package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Approval;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;

import java.util.List;
import java.util.Optional;

public interface ApprovalService {
    Approval approve(Long reqId);

    Optional<Approval> getById(Long id);

    void delete(Long id);

    List<Approval> getByRequisitionId(Long id);

    List<Approval> getAll();

  //  List<Requisition> getByStatus(String approved);
}
