package com.hk.marketplace.controller;

import com.hk.marketplace.entity.FranchisorBrand;
import com.hk.marketplace.entity.Users;
import com.hk.marketplace.repository.UserRepository;
import com.hk.marketplace.service.FranchisorBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/franchisor-brands")
public class FranchisorBrandController {

    @Autowired
    private FranchisorBrandService franchisorBrandService;

    @Autowired
    private UserRepository usersRepository; 
    
    @GetMapping
    public List<FranchisorBrand> getAllBrands() {
        return franchisorBrandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranchisorBrand> getBrandById(@PathVariable Long id) {
        return franchisorBrandService.getBrandById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FranchisorBrand createBrand(@RequestBody() FranchisorBrand brand) throws IOException {
//         if (logoFile != null && !logoFile.isEmpty()) {
//             brand.setLogoUrl(logoFile.getBytes());
//         }
//         String username = userDetails.getUsername();
//         Users user = usersRepository.findByUsername(username); // You need to autowire this repository
//
//         brand.setUser(user);
    	System.out.println("FranchisorBrand");
        return franchisorBrandService.createBrand(brand);
    }
    @PostMapping("/test")
    public String test(@RequestBody() Map<String, String> obj) throws IOException {
    	
    	return "ddk1"+obj.toString();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FranchisorBrand> updateBrand(@PathVariable Long id,
            @RequestPart("brand") FranchisorBrand updatedBrand,
            @RequestPart(value = "logo", required = false) MultipartFile logoFile) throws IOException {
        if (logoFile != null && !logoFile.isEmpty()) {
            updatedBrand.setLogoUrl(logoFile.getBytes());
        }
        return ResponseEntity.ok(franchisorBrandService.updateBrand(id, updatedBrand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        franchisorBrandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
