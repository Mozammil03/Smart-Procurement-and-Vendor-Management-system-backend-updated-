package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorRatingRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;
import com.mywaysai.smartprocurementvendormanagementsystem.service.VendorRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-ratings")
public class VendorRatingController {

    private final VendorRatingService service;

    public VendorRatingController(VendorRatingService service) {
        this.service = service;
    }

    @PostMapping
    public VendorRating create(@RequestBody VendorRatingRequest request) {
        return service.createRating(request);
    }

    @GetMapping
    public List<VendorRating> getAll(@RequestParam(required = false) Long vendorId) {
        if (vendorId != null) {
            return service.getRatingsByVendorId(vendorId);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vendorId query parameter is required");
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorRating> getRatingsByVendorId(@PathVariable Long vendorId) {
        return service.getRatingsByVendorId(vendorId);
    }

    @GetMapping("/admin/ratings")
    public List<VendorRating> getAdminRatings() {
        return service.getAllRatings();
    }

    @PostMapping("/admin/rate")
    public VendorRating adminRate(@RequestBody VendorRatingRequest request) {
        return service.createRating(request);
    }

    @PostMapping("/admin/delete/{vendorId}")
    public void deleteVendorRatings(@PathVariable Long vendorId) {
        service.deleteRatingsByVendorId(vendorId);
    }

    @GetMapping("/{id}")
    public VendorRating getById(@PathVariable Long id) {
        return service.getRatingById(id);
    }
}
