package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findByRequisitionId(Long requisitionId);

    @Query("SELECT p FROM PurchaseOrder p WHERE " +
           "LOWER(p.poNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.vendor.companyName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<PurchaseOrder> searchByKeyword(@Param("keyword") String keyword);
}
