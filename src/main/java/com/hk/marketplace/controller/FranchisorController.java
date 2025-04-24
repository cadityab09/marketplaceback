package com.hk.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hk.marketplace.entity.Franchisee;
import com.hk.marketplace.service.FranchisorService;

import java.util.List;

@RestController
@RequestMapping("/api/franchisor")
@CrossOrigin(origins = "*")
public class FranchisorController {

    @Autowired
    private FranchisorService service;

    @PostMapping("/create-franchisee")
    public Franchisee createFranchisee(@RequestBody Franchisee franchisee) {
        return service.saveFranchisee(franchisee);
    }

    @GetMapping("/get-franchisees")
    public List<Franchisee> getFranchisees() {
        return service.getAllFranchisees();
    }
}