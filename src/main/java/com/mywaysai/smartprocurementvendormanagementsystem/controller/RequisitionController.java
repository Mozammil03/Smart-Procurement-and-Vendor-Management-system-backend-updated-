package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Approval;
import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.service.RequisitionService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requisitions")
@RequiredArgsConstructor
public class RequisitionController {

    private final RequisitionService service;

    @PostMapping
    public Requisition create(@RequestBody Requisition r){
        return service.create(r);
    }

    @GetMapping
    public List<Requisition> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Requisition> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Requisition update(@PathVariable Long id,@RequestBody Requisition r){
        return service.update(id,r);
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id){
//        service.delete(id);
//       // return "Requisition Deleted";
//    }






    @GetMapping("/pending")
    public List<Requisition> getPending() {
        return service.getByStatus("PENDING");
    }

}
