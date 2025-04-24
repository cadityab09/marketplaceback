package com.hk.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.marketplace.entity.Franchisee;
import com.hk.marketplace.repository.FranchisorRepository;

import java.util.List;

@Service
public class FranchisorService {

    @Autowired
    private FranchisorRepository repository;

    public Franchisee saveFranchisee(Franchisee franchisee) {
        return repository.save(franchisee);
    }

    public List<Franchisee> getAllFranchisees() {
        return repository.findAll();
    }
}
