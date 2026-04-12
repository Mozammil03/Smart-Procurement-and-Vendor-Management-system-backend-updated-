package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Approval;

import java.util.List;


public interface ApprovalRepository extends JpaRepository<Approval,Long>{
  //  void deleteByRequisition_Id(Long id);

    List<Approval> findByRequisitionId(Long requisitionId);

}
