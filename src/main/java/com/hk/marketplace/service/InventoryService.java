package com.hk.marketplace.service;

import org.springframework.stereotype.Service;

import com.hk.marketplace.entity.InventoryItem;
import com.hk.marketplace.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<InventoryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<InventoryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public InventoryItem addItem(InventoryItem item) {
        return repository.save(item);
    }

    public InventoryItem updateQuantity(Long id, InventoryItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public Optional<InventoryItem> getItemByName(String name) {
        return repository.findByItemIgnoreCase(name);
    }
}
