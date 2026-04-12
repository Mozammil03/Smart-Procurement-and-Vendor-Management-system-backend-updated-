package com.mywaysai.smartprocurementvendormanagementsystem.controller;


import com.mywaysai.smartprocurementvendormanagementsystem.service.ApprovalService;
import com.mywaysai.smartprocurementvendormanagementsystem.service.PurchaseOrderService;
import com.mywaysai.smartprocurementvendormanagementsystem.service.RequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerDashboardController {

    private final RequisitionService requisitionService;
    private final ApprovalService approvalService;
    private final PurchaseOrderService poService;

    @GetMapping("/dashboard")
    public Map<String, Long> dashboard(){

        long pending = requisitionService.getByStatus("PENDING").size();
        long approved = approvalService.getAll().size();
        long po = poService.all().size();

        Map<String, Long> map = new HashMap<>();

        map.put("pending", pending);
        map.put("approved", approved);
        map.put("purchaseOrders", po);

        return map;
    }
}