package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorDocument;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorDocumentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository repository;
    private final VendorRepository vendorRepository;

    @Override
    public VendorDocument upload(VendorDocument doc){
        return repository.save(doc);
    }

    @Override
    public VendorDocument save(Long vendorId, String name, String type, String number) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        VendorDocument doc = new VendorDocument();
        doc.setDocumentName(name);
        doc.setDocumentType(type);
        doc.setDocumentNumber(number);
        doc.setStatus("PENDING");
        doc.setVendor(vendor);

        return repository.save(doc);
    }

    @Override
    public List<VendorDocument> getAll() {
        return repository.findAll();
    }

    @Override
    public List<VendorDocument> getByVendorId(Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    @Override
    public List<VendorDocument> searchByVendorName(String vendorName) {
        return repository.findByVendorCompanyNameContainingIgnoreCase(vendorName);
    }

    @Override
    public VendorDocument updateStatus(Long documentId, String status, String adminComment) {
        VendorDocument document = repository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        document.setStatus(status);
        document.setAdminComment(adminComment);
        return repository.save(document);
    }

    @Override
    public void deleteById(Long documentId) {
        repository.deleteById(documentId);
    }
}
