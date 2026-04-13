package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorDocument;

public interface VendorDocumentRepository extends JpaRepository<VendorDocument,Long> {
    List<VendorDocument> findByVendorId(Long vendorId);
    List<VendorDocument> findByVendorCompanyNameContainingIgnoreCase(String vendorName);
}

