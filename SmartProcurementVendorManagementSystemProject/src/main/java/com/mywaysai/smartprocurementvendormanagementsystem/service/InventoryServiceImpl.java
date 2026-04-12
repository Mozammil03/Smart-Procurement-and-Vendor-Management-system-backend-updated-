package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Inventory;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repository;

    public Inventory updateStock(Inventory inv){
        return repository.save(inv);
    }

    public List<Inventory> all(){
        return repository.findAll();
    }
}

