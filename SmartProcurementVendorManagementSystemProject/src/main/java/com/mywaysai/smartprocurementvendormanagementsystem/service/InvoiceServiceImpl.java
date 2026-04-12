package com.mywaysai.smartprocurementvendormanagementsystem.service;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    public Invoice create(Invoice invoice){
        return repository.save(invoice);
    }
}

