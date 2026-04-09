package com.mywaysai.smartprocurementvendormanagementsystem.service;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Delivery;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.DeliveryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository repository;

    public Delivery track(Delivery d){
        return repository.save(d);
    }
}
