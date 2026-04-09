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


public class LoginResponse {

    private String token;
    private String role;
    private Long id;   // ADDED

    public LoginResponse(String token, String role, Long id) {
        this.token = token;
        this.role = role;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {   //  ADDED
        return id;
    }
}