package com.hk.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hk.marketplace.entity.InventoryItem;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findByItemIgnoreCase(String item);
    InventoryItem findByItem(String item);
}
