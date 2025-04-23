package com.hk.marketplace.service;

import com.hk.marketplace.entity.FranchisorBrand;
import com.hk.marketplace.repository.FranchisorBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchisorBrandService {

    @Autowired
    private FranchisorBrandRepository franchisorBrandRepository;

    public List<FranchisorBrand> getAllBrands() {
        return franchisorBrandRepository.findAll();
    }

    public Optional<FranchisorBrand> getBrandById(Long id) {
        return franchisorBrandRepository.findById(id);
    }

    public FranchisorBrand createBrand(FranchisorBrand brand) {
        return franchisorBrandRepository.save(brand);
    }

    public FranchisorBrand updateBrand(Long id, FranchisorBrand updatedBrand) {
        return franchisorBrandRepository.findById(id).map(brand -> {
            brand.setName(updatedBrand.getName());
            brand.setLogoUrl(updatedBrand.getLogoUrl());
            brand.setMainOfficeLocation(updatedBrand.getMainOfficeLocation());
            brand.setYearsInBusiness(updatedBrand.getYearsInBusiness());
            brand.setNumberOfEmployees(updatedBrand.getNumberOfEmployees());
            brand.setSpecialization(updatedBrand.getSpecialization());
            brand.setContactEmail(updatedBrand.getContactEmail());
            brand.setWebsiteUrl(updatedBrand.getWebsiteUrl());
            brand.setUser(updatedBrand.getUser());
            return franchisorBrandRepository.save(brand);
        }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    public void deleteBrand(Long id) {
        franchisorBrandRepository.deleteById(id);
    }
}
