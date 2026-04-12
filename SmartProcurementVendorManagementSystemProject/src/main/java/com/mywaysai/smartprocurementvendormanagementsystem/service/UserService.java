package com.mywaysai.smartprocurementvendormanagementsystem.service;


import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.User;

public interface UserService {
    User save(User user);
    List<User> getAll();
    User getById(Long id);
    void delete(Long id);
}
