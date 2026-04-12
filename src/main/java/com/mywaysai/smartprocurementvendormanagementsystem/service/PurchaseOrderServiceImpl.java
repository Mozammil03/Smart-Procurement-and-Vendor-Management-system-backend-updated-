package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RequisitionRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepository;
    private final VendorRepository vendorRepository;
    private final RequisitionRepository requisitionRepository;
<<<<<<< HEAD

    @Override
    public PurchaseOrder create(Long vendorId, Long requisitionId, Double totalAmount) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
        Requisition requisition = requisitionRepository.findById(requisitionId).orElseThrow();
=======
//    public PurchaseOrder create(Long vendorId){
//
//        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
//
//        PurchaseOrder po = new PurchaseOrder();
//        po.setPoNumber("PO-" + System.currentTimeMillis());
//        po.setStatus("CREATED");
//        po.setOrderDate(LocalDate.now());
//        po.setVendor(vendor);
//
//        return poRepository.save(po);
//    }


    @Override
    public PurchaseOrder create(Long vendorId, Long requisitionId){

        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();

        Requisition requisition = requisitionRepository
                .findById(requisitionId)
                .orElseThrow();
>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af

        PurchaseOrder po = new PurchaseOrder();
        po.setPoNumber("PO-" + System.currentTimeMillis());
        po.setStatus("CREATED");
        po.setOrderDate(LocalDate.now());
        po.setVendor(vendor);
<<<<<<< HEAD
        po.setRequisition(requisition);
        if (totalAmount != null) {
            po.setTotalAmount(totalAmount);
        }
        // Single save — totalAmount is included before persist
        return poRepository.save(po);
    }

    public List<PurchaseOrder> all() {
=======
        po.setRequisition(requisition);   //  VERY IMPORTANT

        return poRepository.save(po);
    }
    public List<PurchaseOrder> all(){
>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
        return poRepository.findAll();
    }

    public Optional<PurchaseOrder> getById(Long id) {
        return poRepository.findById(id);
    }

<<<<<<< HEAD
    @Override
    public List<PurchaseOrder> getByRequisition(Long id) {
        return poRepository.findByRequisitionId(id);
    }

    @Override
    public void delete(Long id) {
        poRepository.deleteById(id);
    }

    @Override
    public List<PurchaseOrder> search(String keyword) {
        return poRepository.searchByKeyword(keyword);
    }
=======


@Override
public List<PurchaseOrder> getByRequisition(Long id){
        return poRepository.findByRequisitionId(id);
    }


>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
}
