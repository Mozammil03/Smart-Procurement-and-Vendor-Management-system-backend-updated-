package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Department;
import com.mywaysai.smartprocurementvendormanagementsystem.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    public Department add(@RequestBody Department d){
        return service.add(d);
    }

    @GetMapping
    public List<Department> all(){
        return service.all();
    }


    @GetMapping("/{id}")
    public Department get(@PathVariable Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id,@RequestBody Department d){
        return service.update(id,d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
