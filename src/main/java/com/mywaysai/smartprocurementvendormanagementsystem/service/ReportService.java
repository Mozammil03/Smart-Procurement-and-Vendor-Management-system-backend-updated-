// package com.mywaysai.smartprocurementvendormanagementsystem.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.mywaysai.smartprocurementvendormanagementsystem.dto.SpendReportDTO;
// import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
// import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class ReportService {

//     private final PurchaseOrderRepository repository;

//     // public List<PurchaseOrder> spendAnalysis(){
//     //     return repository.findAll();
//     // }
//     // ReportService.java


//     // now i have pasted by claude
//     public List<SpendReportDTO> spendAnalysis() {
//         List<PurchaseOrder> orders = purchaseOrderRepository.findAll();
//         List<SpendReportDTO> result = new ArrayList<>();
//             for (PurchaseOrder po : orders) {
//         SpendReportDTO dto = new SpendReportDTO();
//         dto.setPoNumber(po.getPoNumber());
//         dto.setOrderDate(po.getOrderDate().toString());
//         dto.setVendorName(po.getVendor().getCompanyName());
//         dto.setPoStatus(po.getStatus());
//         // find invoice linked to this PO
//         invoiceRepository.findByPurchaseOrderId(po.getId()).ifPresent(inv -> {
//             dto.setInvoiceNumber(inv.getInvoiceNumber());
//             dto.setInvoiceAmount(inv.getAmount());
//             // find payment linked to that invoice
//             paymentRepository.findByInvoiceId(inv.getId()).ifPresent(pay -> {
//                 dto.setPaidAmount(pay.getPaidAmount());
//                 dto.setPaymentMode(pay.getPaymentMode());
//                 dto.setPaymentStatus(pay.getStatus());
//                 dto.setPaymentDate(pay.getPaymentDate().toString());
//             });
//         });
//         result.add(dto);
//     }
//     return result;
// }
// }



package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.SpendReportDTO;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Payment;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.InvoiceRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PaymentRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final InvoiceRepository invoiceRepository;
    private final PaymentRepository paymentRepository;

    public List<SpendReportDTO> spendAnalysis() {
        List<PurchaseOrder> orders = purchaseOrderRepository.findAll();
        List<SpendReportDTO> result = new ArrayList<>();

        for (PurchaseOrder po : orders) {
            SpendReportDTO dto = new SpendReportDTO();
            dto.setPoId(po.getId());
            dto.setPoNumber(po.getPoNumber());
            dto.setOrderDate(po.getOrderDate() != null ? po.getOrderDate().toString() : "");
            dto.setVendorName(po.getVendor() != null ? po.getVendor().getCompanyName() : "");
            dto.setPoStatus(po.getStatus());

            Optional<Invoice> invoiceOpt = invoiceRepository.findByPurchaseOrderId(po.getId());
            invoiceOpt.ifPresent(inv -> {
                dto.setInvoiceNumber(inv.getInvoiceNumber());
                dto.setInvoiceAmount(inv.getAmount());

                Optional<Payment> paymentOpt = paymentRepository.findByInvoiceId(inv.getId());
                paymentOpt.ifPresent(pay -> {
                    dto.setPaidAmount(pay.getPaidAmount());
                    dto.setPaymentMode(pay.getPaymentMode());
                    dto.setPaymentStatus(pay.getStatus());
                    dto.setPaymentDate(pay.getPaymentDate() != null ? pay.getPaymentDate().toString() : "");
                });
            });

            result.add(dto);
        }

        return result;
    }
}