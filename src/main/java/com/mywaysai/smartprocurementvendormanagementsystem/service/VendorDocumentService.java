package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorDocument;

import java.util.List;

public interface VendorDocumentService {
    VendorDocument upload(VendorDocument doc);

    VendorDocument save(Long vendorId, String name, String type, String number);

    List<VendorDocument> getAll();

    List<VendorDocument> getByVendorId(Long vendorId);

    List<VendorDocument> searchByVendorName(String vendorName);

    VendorDocument updateStatus(Long documentId, String status, String adminComment);

    void deleteById(Long documentId);
}
