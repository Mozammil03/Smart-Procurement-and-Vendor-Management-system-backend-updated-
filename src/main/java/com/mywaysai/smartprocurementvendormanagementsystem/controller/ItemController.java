package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.service.ItemService;
=======

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.service.ItemService;

>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PostMapping
<<<<<<< HEAD
    public Item add(@RequestBody Item item) {
=======
    public Item add(@RequestBody Item item){
>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
        return service.add(item);
    }

    @GetMapping
<<<<<<< HEAD
    public List<Item> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Item deleted";
    }
}
=======
    public List<Item> list(){
        return service.list();
    }
}

>>>>>>> 2cc9516b2cdc886933c194a22df3e49ba0bf40af
