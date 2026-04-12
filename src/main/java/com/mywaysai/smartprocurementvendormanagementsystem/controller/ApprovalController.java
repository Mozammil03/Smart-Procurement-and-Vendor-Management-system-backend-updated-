package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Approval;
import com.mywaysai.smartprocurementvendormanagementsystem.service.ApprovalService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService service;

    @PostMapping("/{id}")
    public Approval approve(@PathVariable Long id){
        return service.approve(id);
    }


    @GetMapping("/{id}")
    public Optional<Approval> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Approval Deleted";
    }
//    @GetMapping("/requisition/{id}")
//    public List<Approval> getByRequisition(@PathVariable Long id){
//        return service.getByRequisitionId(id);
//    }

    @GetMapping
    public List<Approval> getAll(){
        return service.getAll();
    }




//    @GetMapping("/approved")
//    public List<Requisition> getApproved() {
//        return service.getByStatus("APPROVED");
//    }
}

