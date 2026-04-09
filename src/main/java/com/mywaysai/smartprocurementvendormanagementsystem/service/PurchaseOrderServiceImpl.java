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

        PurchaseOrder po = new PurchaseOrder();
        po.setPoNumber("PO-" + System.currentTimeMillis());
        po.setStatus("CREATED");
        po.setOrderDate(LocalDate.now());
        po.setVendor(vendor);
        po.setRequisition(requisition);   //  VERY IMPORTANT

        return poRepository.save(po);
    }
    public List<PurchaseOrder> all(){
        return poRepository.findAll();
    }

    public Optional<PurchaseOrder> getById(Long id) {
        return poRepository.findById(id);
    }



@Override
public List<PurchaseOrder> getByRequisition(Long id){
        return poRepository.findByRequisitionId(id);
    }


}
