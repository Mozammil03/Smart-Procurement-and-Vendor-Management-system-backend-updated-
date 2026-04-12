package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public Role create(Role role){
        return repository.save(role);
    }

    public List<Role> list(){
        return repository.findAll();
    }








    @Override
    public Role getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    @Override
    public Role update(Long id, Role role) {

        Role existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        existing.setRoleName(role.getRoleName());
     //   existing.setDescription(role.getDescription());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
