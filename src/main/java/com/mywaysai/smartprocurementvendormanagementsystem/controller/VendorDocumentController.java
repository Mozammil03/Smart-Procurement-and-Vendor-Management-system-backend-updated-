package com.mywaysai.smartprocurementvendormanagementsystem.controller;


import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorDocumentRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorDocumentReviewRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorDocument;
import com.mywaysai.smartprocurementvendormanagementsystem.service.VendorDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService service;

    public VendorDocumentController(VendorDocumentService service) {
        this.service = service;
    }

    @PostMapping
    public VendorDocument create(@RequestBody VendorDocumentRequest req){
        return service.save(req.getVendorId(), req.getDocumentName(), req.getDocumentType(), req.getDocumentNumber());
    }

    @GetMapping
    public List<VendorDocument> all(@RequestParam(required = false) Long vendorId,
                                    @RequestParam(required = false) String vendorName) {
        if (vendorId != null) {
            return service.getByVendorId(vendorId);
        }
        if (vendorName != null && !vendorName.isBlank()) {
            if (vendorName.matches("\\d+")) {
                return service.getByVendorId(Long.valueOf(vendorName));
            }
            return service.searchByVendorName(vendorName);
        }
        return service.getAll();
    }

    @PutMapping("/{id}/review")
    public VendorDocument review(@PathVariable Long id,
                                 @RequestBody VendorDocumentReviewRequest req) {
        return service.updateStatus(id, req.getStatus(), req.getAdminComment());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}



