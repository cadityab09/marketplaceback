package com.hk.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hk.marketplace.entity.Franchisee;

@Repository
public interface FranchisorRepository extends JpaRepository<Franchisee, Long> {
}

