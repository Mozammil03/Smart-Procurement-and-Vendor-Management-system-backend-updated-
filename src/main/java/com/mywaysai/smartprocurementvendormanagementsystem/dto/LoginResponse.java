package com.mywaysai.smartprocurementvendormanagementsystem.dto;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class LoginResponse {
//
//    private String token;
//    private String role;
//
//    public LoginResponse(String token, String role) {
//        this.token = token;
//        this.role = role;
//    }
//
//}


import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

    private String token;
    private String role;
    private Long vendorId;

    @JsonProperty("id")
    private Long id;

    public LoginResponse(String token, String role, Long vendorId, Long id) {
        this.token = token;
        this.role = role;
        this.vendorId = vendorId;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public Long getId() {
        return id;
    }
}