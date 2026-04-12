package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    public Item add(Item item) {
        return repository.save(item);
    }

    public List<Item> list() {
        return repository.findAll();
    }

    public Item getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found: " + id));
    }

    public Item update(Long id, Item updated) {
        Item existing = getById(id);
        existing.setItemName(updated.getItemName());
        existing.setCategory(updated.getCategory());
        existing.setUnitPrice(updated.getUnitPrice());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
