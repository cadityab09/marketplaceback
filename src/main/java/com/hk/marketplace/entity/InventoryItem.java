package com.hk.marketplace.entity;

import com.hk.marketplace.enums.ItemStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_items")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    public InventoryItem() {}

    public InventoryItem(String item, int quantity, ItemStatus status) {
        this.item = item;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getItem() { return item; }

    public void setItem(String item) { this.item = item; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public ItemStatus getStatus() { return status; }

    public void setStatus(ItemStatus status) { this.status = status; }
}
