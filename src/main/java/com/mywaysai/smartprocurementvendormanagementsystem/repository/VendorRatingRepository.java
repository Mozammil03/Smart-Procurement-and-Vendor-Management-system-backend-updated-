package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;

import java.util.List;

public interface VendorRatingRepository extends JpaRepository<VendorRating, Long> {
    List<VendorRating> findByVendorId(Long vendorId);
    void deleteByVendorId(Long vendorId);
}

