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
    public PurchaseOrder create(@RequestParam Long vendorId,
                                @RequestParam Long requisitionId,
                                @RequestParam(required = false) Double totalAmount) {
        // totalAmount passed into service so it's saved in one transaction
        return service.create(vendorId, requisitionId, totalAmount);
    }

    @GetMapping
    public List<PurchaseOrder> all(@RequestParam(required = false) Long vendorId) {
        if (vendorId != null) {
            return service.getByVendorId(vendorId);
        }
        return service.all();
    }

    @GetMapping("/{id}")
    public Optional<PurchaseOrder> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/requisition/{id}")
    public List<PurchaseOrder> getByRequisition(@PathVariable Long id) {
        return service.getByRequisition(id);
    }

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
