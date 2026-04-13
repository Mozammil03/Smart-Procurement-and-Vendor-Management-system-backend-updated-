package com.mywaysai.smartprocurementvendormanagementsystem.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mywaysai.smartprocurementvendormanagementsystem.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/vendors/**").hasRole("ADMIN")
//                .requestMatchers("/requisitions/**").hasRole("EMPLOYEE")
//                .requestMatchers("/approvals/**").hasRole("MANAGER")
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }









//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/roles/**").permitAll()   // ✅ allow roles
//                        .requestMatchers("/vendors/**").hasRole("ADMIN")
//                        .requestMatchers("/requisitions/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/approvals/**").hasRole("MANAGER")
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/users/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/vendors").permitAll()
                        
                        // User endpoints (authenticated users can get their info)
                        .requestMatchers(HttpMethod.GET, "/users/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/users/**").authenticated()
                        
                        // Admin endpoints
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/vendors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/vendors/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/vendors/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/vendors/**").hasRole("ADMIN")
                        .requestMatchers("/roles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/po").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/po/**").hasRole("ADMIN")
                        
                        // Purchase Order endpoints
                        .requestMatchers(HttpMethod.GET, "/po", "/po/**").hasAnyRole("ADMIN", "VENDOR", "MANAGER", "FINANCE")
                        .requestMatchers(HttpMethod.GET, "/requisitions/**").hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE")
                        
                        // Employee endpoints
                        .requestMatchers(HttpMethod.POST, "/requisitions").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/requisitions/**").hasRole("EMPLOYEE")
                        
                        // Manager endpoints
                        .requestMatchers("/approvals/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/requisitions/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        
                        // Finance endpoints
                        .requestMatchers("/reports/**").hasRole("FINANCE")
                        .requestMatchers("/invoice/**").hasAnyRole("VENDOR", "FINANCE")
                        .requestMatchers(HttpMethod.GET, "/invoices/**").hasRole("FINANCE")
                        .requestMatchers(HttpMethod.GET, "/payments/**").hasRole("FINANCE")
                        
                        // Vendor Document endpoints
                        .requestMatchers(HttpMethod.GET, "/api/vendor-documents", "/api/vendor-documents/**").hasAnyRole("ADMIN", "VENDOR")
                        .requestMatchers(HttpMethod.POST, "/api/vendor-documents").hasRole("VENDOR")
                        .requestMatchers(HttpMethod.PUT, "/api/vendor-documents/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/vendor-documents/**").hasAnyRole("ADMIN", "VENDOR")
                        
                        // Vendor Rating endpoints
                        .requestMatchers("/api/vendor-ratings/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/vendor-ratings/vendor/**").hasAnyRole("ADMIN", "VENDOR")
                        .requestMatchers(HttpMethod.POST, "/api/vendor-ratings").hasRole("ADMIN")
                        
                        // Delivery endpoints
                        .requestMatchers("/api/deliveries/**").hasAnyRole("VENDOR", "ADMIN")
                        
                        // Default: any other request requires authentication
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}

