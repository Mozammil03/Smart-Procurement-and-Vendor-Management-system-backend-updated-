package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;
import com.mywaysai.smartprocurementvendormanagementsystem.service.InvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService service;

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        return service.create(invoice);
    }
}
