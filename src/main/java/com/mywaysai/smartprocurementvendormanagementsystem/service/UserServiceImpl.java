package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.LoginRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.dto.LoginResponse;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Department;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.DepartmentRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RoleRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.User;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository  departmentRepository;
    private final VendorRepository vendorRepository;
    private final JwtService jwtService;
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User createUser(User user) {

        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setActive(true);

        Role role = roleRepository.findById(user.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));


        Department department = departmentRepository.findById(user.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        user1.setDepartment(department);
        user1.setRole(role);

        return repository.save(user1);
    }
    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
//
//    @Override
//    public User getById(Long id) {
//        return repository.findById(id).orElseThrow();
//    }
//
//    @Override
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }


















    @Override
    public LoginResponse login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        if (user.getRole() == null) {
            throw new RuntimeException("User role not assigned");
        }

        Long vendorId = null;

        // CHECK ONLY IF ROLE = VENDOR
        if (user.getRole().getRoleName().equalsIgnoreCase("VENDOR")) {
            Optional<Vendor> optionalVendor = vendorRepository.findByEmail(user.getEmail());

            if (optionalVendor.isPresent()) {
                Vendor vendor = optionalVendor.get();
                vendorId = vendor.getId();
            }
        }

        return new LoginResponse(
                jwtService.generateToken(user),
                user.getRole().getRoleName(),
                vendorId,
                user.getId()
        );
    }


    @Override
    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User update(Long id, User u) {

        User existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUsername(u.getUsername());
        existing.setEmail(u.getEmail());
        existing.setPassword(u.getPassword());
        existing.setActive(u.isActive());
        existing.setRole(u.getRole());
        existing.setDepartment(u.getDepartment());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
