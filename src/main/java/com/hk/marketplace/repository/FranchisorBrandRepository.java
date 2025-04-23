package com.hk.marketplace.repository;

import com.hk.marketplace.entity.FranchisorBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchisorBrandRepository extends JpaRepository<FranchisorBrand, Long> {
}
