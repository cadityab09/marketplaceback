package com.hk.marketplace.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "franchisees")
public class Franchisee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;

    private String location;

    private String email;

    private Double lastMonthIncome;

    private Double amountPaid;

    private String paymentMethod;

    private LocalDate startDate;

    // Constructors
    public Franchisee() {}

    public Franchisee(String owner, String location, String email, Double lastMonthIncome, Double amountPaid, String paymentMethod, LocalDate startDate) {
        this.owner = owner;
        this.location = location;
        this.email = email;
        this.lastMonthIncome = lastMonthIncome;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
        this.startDate = startDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getLastMonthIncome() {
        return lastMonthIncome;
    }

    public void setLastMonthIncome(Double lastMonthIncome) {
        this.lastMonthIncome = lastMonthIncome;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
