// package com.mywaysai.smartprocurementvendormanagementsystem.controller;

// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.mywaysai.smartprocurementvendormanagementsystem.dto.SpendReportDTO;
// import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
// import com.mywaysai.smartprocurementvendormanagementsystem.service.ReportService;

// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/reports")
// @RequiredArgsConstructor
// public class ReportController {

//     private final ReportService service;

//     // @GetMapping("/spend")
//     // public List<PurchaseOrder> report(){
//     //     return service.spendAnalysis();
//     // }

//     // ReportController.java — add this
// @GetMapping("/export/csv")
// public void exportCsv(HttpServletResponse response) throws IOException {
//     response.setContentType("text/csv");
//     response.setHeader("Content-Disposition", "attachment; filename=spend-report.csv");
//     List<SpendReportDTO> data = service.spendAnalysis();
//     PrintWriter writer = response.getWriter();
//     writer.println("PO Number,Order Date,Vendor,PO Status,Invoice No,Invoice Amount,Paid Amount,Payment Mode,Payment Status,Payment Date");
//     for (SpendReportDTO r : data) {
//         writer.printf("%s,%s,%s,%s,%s,%.2f,%.2f,%s,%s,%s%n",
//             r.getPoNumber(), r.getOrderDate(), r.getVendorName(), r.getPoStatus(),
//             r.getInvoiceNumber(), r.getInvoiceAmount(), r.getPaidAmount(),
//             r.getPaymentMode(), r.getPaymentStatus(), r.getPaymentDate());
//     }
// }
// }



package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.SpendReportDTO;
import com.mywaysai.smartprocurementvendormanagementsystem.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService service;

    @GetMapping("/spend")
    public List<SpendReportDTO> report() {
        return service.spendAnalysis();
    }

    @GetMapping("/export/csv")
    public void exportCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=spend-report.csv");

        List<SpendReportDTO> data = service.spendAnalysis();
        PrintWriter writer = response.getWriter();

        writer.println("PO Number,Order Date,Vendor,PO Status,Invoice No,Invoice Amount,Paid Amount,Payment Mode,Payment Status,Payment Date");

        for (SpendReportDTO r : data) {
            writer.printf("%s,%s,%s,%s,%s,%.2f,%.2f,%s,%s,%s%n",
                nullSafe(r.getPoNumber()),
                nullSafe(r.getOrderDate()),
                nullSafe(r.getVendorName()),
                nullSafe(r.getPoStatus()),
                nullSafe(r.getInvoiceNumber()),
                r.getInvoiceAmount(),
                r.getPaidAmount(),
                nullSafe(r.getPaymentMode()),
                nullSafe(r.getPaymentStatus()),
                nullSafe(r.getPaymentDate())
            );
        }
    }

    private String nullSafe(String val) {
        return val != null ? val : "";
    }
}