package com.hk.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hk.marketplace.entity.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
