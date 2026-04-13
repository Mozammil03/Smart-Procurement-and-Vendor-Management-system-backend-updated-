package com.mywaysai.smartprocurementvendormanagementsystem.service;

//import org.springframework.stereotype.Service;
//
//import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;
//import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRatingRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class VendorRatingServiceImpl implements VendorRatingService {
//
//    private final VendorRatingRepository repository;
//
//    public VendorRating rate(VendorRating rating){
//        return repository.save(rating);
//    }
//
import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorRatingRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.User;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.UserRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRatingRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

    @Service
    public class VendorRatingServiceImpl implements VendorRatingService {

        private final VendorRatingRepository ratingRepository;
        private final VendorRepository vendorRepository;

        public VendorRatingServiceImpl(VendorRatingRepository ratingRepository,
                                       VendorRepository vendorRepository) {
            this.ratingRepository = ratingRepository;
            this.vendorRepository = vendorRepository;
        }

        @Autowired
        UserRepository userRepository;

        @Override
        public VendorRating createRating(VendorRatingRequest request) {

            if (request == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required");
            }
            if (request.getVendorId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vendorId is required");
            }
            if (request.getRatedByUserId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ratedByUserId is required");
            }

            Vendor vendor = vendorRepository.findById(request.getVendorId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendor not found"));

            User user = userRepository.findById(request.getRatedByUserId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

            VendorRating rating = new VendorRating();
            rating.setVendor(vendor);
            rating.setRatedBy(user);
            rating.setQualityScore(request.getQualityScore());
            rating.setDeliveryScore(request.getDeliveryScore());
            rating.setPriceScore(request.getPriceScore());
            rating.setComments(request.getComments());
            rating.setIsAdminRating(request.getIsAdminRating() != null ? request.getIsAdminRating() : true);

            return ratingRepository.save(rating);
        }
        @Override
        public List<VendorRating> getAllRatings() {
            return ratingRepository.findAll();
        }

        @Override
        public List<VendorRating> getRatingsByVendorId(Long vendorId) {
            return ratingRepository.findByVendorId(vendorId);
        }

        @Override
        public VendorRating getRatingById(Long id) {
            return ratingRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rating not found"));
        }

        @Override
        public VendorRating rate(VendorRating rating) {
            return ratingRepository.save(rating);
        }

        @Override
        @Transactional
        public void deleteRatingsByVendorId(Long vendorId) {
            ratingRepository.deleteByVendorId(vendorId);
        }
    }


