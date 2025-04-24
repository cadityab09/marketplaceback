package com.hk.marketplace.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hk.marketplace.entity.InventoryItem;
import com.hk.marketplace.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "*") // Allow CORS for development
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return service.getAllItems();
    }

    @PostMapping
    public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem item) {
        return ResponseEntity.ok(service.addItem(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItem> updateQuantity(@PathVariable Long id, @RequestBody InventoryItem item) {
        return ResponseEntity.ok(service.updateQuantity(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
