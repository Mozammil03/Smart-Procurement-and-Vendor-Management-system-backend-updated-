package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import com.mywaysai.smartprocurementvendormanagementsystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/dashboard")
@RequiredArgsConstructor
public class AdminDashboardController {

    private final VendorRepository vendorRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final InventoryRepository inventoryRepository;
    private final RequisitionRepository requisitionRepository;
    private final ItemRepository itemRepository;

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();

        long totalVendors = vendorRepository.count();
        long approvedVendors = vendorRepository.findAll().stream()
                .filter(v -> v.isApproved()).count();
        long pendingVendors = totalVendors - approvedVendors;

        long totalPOs = purchaseOrderRepository.count();

        long totalItems = itemRepository.count();

        // Low stock: quantity < 10
        long lowStockAlerts = inventoryRepository.findAll().stream()
                .filter(inv -> inv.getQuantityAvailable() < 10).count();

        // Pending requisitions
        long pendingRequisitions = requisitionRepository.findAll().stream()
                .filter(r -> "PENDING".equalsIgnoreCase(r.getStatus())).count();

        // Total spend from POs with totalAmount set
        double totalSpend = purchaseOrderRepository.findAll().stream()
                .filter(po -> po.getTotalAmount() != null)
                .mapToDouble(po -> po.getTotalAmount())
                .sum();

        stats.put("totalVendors", totalVendors);
        stats.put("approvedVendors", approvedVendors);
        stats.put("pendingVendors", pendingVendors);
        stats.put("totalPurchaseOrders", totalPOs);
        stats.put("totalItems", totalItems);
        stats.put("lowStockAlerts", lowStockAlerts);
        stats.put("pendingRequisitions", pendingRequisitions);
        stats.put("totalSpend", totalSpend);

        return stats;
    }
}
