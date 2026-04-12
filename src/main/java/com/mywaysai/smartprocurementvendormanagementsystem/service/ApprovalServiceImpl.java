package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Approval;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ApprovalRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RequisitionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final RequisitionRepository requisitionRepository;

    public Approval approve(Long reqId){

        Requisition req = requisitionRepository.findById(reqId).orElseThrow();
        req.setStatus("APPROVED");

        Approval approval = new Approval();
        approval.setRequisition(req);
        approval.setDecision("APPROVED");
        approval.setApprovedDate(LocalDateTime.now());

        requisitionRepository.save(req);
        return approvalRepository.save(approval);
    }

    @Override
    public Optional<Approval> getById(Long id) {
        return approvalRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        approvalRepository.deleteById(id);

    }
    @Override
    public List<Approval> getByRequisitionId(Long id){
        return approvalRepository.findByRequisitionId(id);
    }

    @Override
    public List<Approval> getAll() {
        return approvalRepository.findAll();
    }

















//    public List<Requisition> getByStatus(String status){
//        return approvalRepository.findByStatus(status);
//    }
}
