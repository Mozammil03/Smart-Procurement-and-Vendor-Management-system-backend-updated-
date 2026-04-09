package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;

    @Override
    public Vendor register(Vendor vendor) {
        vendor.setApproved(false);
        return repository.save(vendor);
    }

    @Override
    public List<Vendor> getAll() {
        return repository.findAll();
    }
}
