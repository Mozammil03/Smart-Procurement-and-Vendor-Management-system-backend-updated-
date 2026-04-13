package com.mywaysai.smartprocurementvendormanagementsystem.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorRatingRequest {

    private Long vendorId;
    private Long ratedByUserId;
    private int qualityScore;
    private int deliveryScore;
    private int priceScore;
    private String comments;

    @JsonProperty("isAdminRating")
    private Boolean isAdminRating;
}