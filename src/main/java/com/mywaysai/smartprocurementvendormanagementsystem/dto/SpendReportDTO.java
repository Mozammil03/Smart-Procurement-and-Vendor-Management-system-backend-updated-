package com.mywaysai.smartprocurementvendormanagementsystem.dto;

public class SpendReportDTO {
    private Long poId;
    private String poNumber;
    private String orderDate;
    private String vendorName;
    private String poStatus;
    private String invoiceNumber;   // from Invoice table
    private double invoiceAmount;   // from Invoice table
    private double paidAmount;      // from Payment table
    private String paymentMode;     // from Payment table
    private String paymentStatus;   // from Payment table
    private String paymentDate;     // from Payment table


    public Long getPoId() { return poId; }
    public void setPoId(Long poId) { this.poId = poId; }

    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getPoStatus() { return poStatus; }
    public void setPoStatus(String poStatus) { this.poStatus = poStatus; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public double getInvoiceAmount() { return invoiceAmount; }
    public void setInvoiceAmount(double invoiceAmount) { this.invoiceAmount = invoiceAmount; }

    public double getPaidAmount() { return paidAmount; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
}

