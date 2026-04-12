package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.service.PurchaseOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/po")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    @PostMapping
<<<<<<< HEAD
    public PurchaseOrder create(@RequestParam Long vendorId,
                                @RequestParam Long requisitionId,
                                @RequestParam(required = false) Double totalAmount) {
        // totalAmount passed into service so it's saved in one transaction
        return service.create(vendorId, requisitionId, totalAmount);
    }

    @GetMapping
    public List<PurchaseOrder> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<PurchaseOrder> getById(@PathVariable Long id) {
        return service.getById(id);
    }

=======
    public PurchaseOrder create( @RequestParam Long vendorId,
                                 @RequestParam Long requisitionId){
        return service.create(vendorId,requisitionId);
    }

    @GetMapping
    public List<PurchaseOrder> all(){
        return service.all();
    }


    @GetMapping("/{id}")
    public Optional<PurchaseOrder> getById(@PathVariable Long id){
        return service.getById(id);
    }


>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
    @GetMapping("/requisition/{id}")
    public List<PurchaseOrder> getByRequisition(@PathVariable Long id) {
        return service.getByRequisition(id);
    }
<<<<<<< HEAD

    @GetMapping("/search")
    public List<PurchaseOrder> search(@RequestParam String keyword) {
        return service.search(keyword);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "PO deleted";
    }
}
=======
    }









//
//Monish R
//
//Muthuselvi C
//8:38 PM
//Muthuselvi C
//
//Sai Shobana Sri H
//8:38 PM
//SAI SHOBANA SRI
//
//Dhruv Battawar
//8:38 PM
//Dhruv Battawar
//
//Partha Pratim Makhal
//8:38 PM
//Partha Pratim Makhal
//
//RVibin Shree
//8:38 PM
//Vibin sri R
//
//        Kishor
//8:38 PM
//Kishor S
//
//Mozammil
//8:38 PM
//        Mozammil
//
//Ganesh n Bambulage
//8:38 PM
//Ganesh N bambulage
//
//239X1A3258 SIRIGIREDDY NITHIN REDDY
//8:38 PM
//        NITHIN
//
//Jyoshna K
//8:38 PM
//jyoshna Koppisetti
//
//jeruslin vince
//8:38 PM
//Jeruslin Vince V
//
//Trishna Ravi
//8:38 PM
//        Trishna
//
//Shaik Chand bhasha
//8:38 PM
//SHAIK CHAND BHASHA
//
//Yuvaraaj R K
//8:38 PM
//        Yuvaraaj
//
//Tejaswini Thakur
//8:38 PM
//Tejaswini Thakur
>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
