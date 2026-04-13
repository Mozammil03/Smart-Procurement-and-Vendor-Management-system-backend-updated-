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
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/users/auth/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/po", "/po/**").hasAnyRole("ADMIN", "VENDOR")
                        .requestMatchers(HttpMethod.POST, "/po").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/po/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/vendor-documents", "/api/vendor-documents/**").hasAnyRole("ADMIN", "VENDOR")
                        .requestMatchers(HttpMethod.POST, "/api/vendor-documents").hasRole("VENDOR")
                        .requestMatchers(HttpMethod.PUT, "/api/vendor-documents/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/vendor-documents/**").hasAnyRole("ADMIN", "VENDOR")
                        .requestMatchers("/roles/**").hasRole("ADMIN")
                        .requestMatchers("/api/vendor-ratings/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/vendor-ratings/vendor/**").hasAnyRole("ADMIN", "VENDOR")
                        .requestMatchers(HttpMethod.GET, "/admin/dashboard/**").hasRole("ADMIN")
                        .requestMatchers("/vendors/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/requisitions/**").hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/requisitions/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/requisitions/**").hasRole("EMPLOYEE")
                        .requestMatchers("/approvals/**").hasRole("MANAGER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}

