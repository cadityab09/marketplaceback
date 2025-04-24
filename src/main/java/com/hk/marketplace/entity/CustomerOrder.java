package com.hk.marketplace.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String itemName;
    private int quantity;
    private double price;
    private LocalDateTime orderTime;

    public CustomerOrder() {
        this.orderTime = LocalDateTime.now();
    }

    public CustomerOrder(String customerName, String itemName, int quantity, double price) {
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.orderTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    
    
}
