package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ItemRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RequisitionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequisitionServiceImpl implements RequisitionService {

    private final RequisitionRepository repository;
    private final ItemRepository itemRepository;
    private final EmailService emailService;

    @Override
    public Requisition create(Requisition r){

        Item item = itemRepository.findById(r.getItem().getId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        r.setItem(item);
        r.setStatus("PENDING");

        Requisition saved = repository.save(r);

        // 📧 Email Logic
        String managerEmail = "ganeshnbbombulage@gmail.com";

        String subject = "New Requisition Created";
        String body = "Hello Manager,\n\n"
                + "A new requisition has been created.\n"
                + "Requisition ID: " + saved.getId() + "\n"
                + "Item: " + saved.getItem().getItemName() + "\n"
                + "Quantity: " + saved.getQuantity() + "\n\n"
                + "Please review it.";

        emailService.sendSimpleMail(managerEmail, subject, body);

        return saved;
    }

    @Override
    public List<Requisition> list(){
        return repository.findAll();
    }

    @Override
    public List<Requisition> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Requisition> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Requisition update(Long id, Requisition r) {

        Requisition existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requisition not found"));

        existing.setItem(r.getItem());
        existing.setQuantity(r.getQuantity());
        existing.setStatus(r.getStatus());

        return repository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public List<Requisition> getByStatus(String status) {
        return repository.findByStatus(status);
    }
}
