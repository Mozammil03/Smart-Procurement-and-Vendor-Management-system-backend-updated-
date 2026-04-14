// package com.mywaysai.smartprocurementvendormanagementsystem.repository;

// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;

// import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;
// import com.mywaysai.smartprocurementvendormanagementsystem.entity.Payment;


// public interface InvoiceRepository extends JpaRepository<Invoice,Long>{ 

// this is claude

//     Optional<Invoice> findByPurchaseOrderId(Long purchaseOrderId);
//     Optional<Payment> findByInvoiceId(Long invoiceId);
// }

package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByPurchaseOrderId(Long purchaseOrderId);
}