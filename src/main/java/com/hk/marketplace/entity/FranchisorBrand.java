package com.hk.marketplace.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "franchisor_brands")
// @Data
public class FranchisorBrand {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(byte[] logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getMainOfficeLocation() {
        return mainOfficeLocation;
    }

    public void setMainOfficeLocation(String mainOfficeLocation) {
        this.mainOfficeLocation = mainOfficeLocation;
    }

    public Integer getYearsInBusiness() {
        return yearsInBusiness;
    }

    public void setYearsInBusiness(Integer yearsInBusiness) {
        this.yearsInBusiness = yearsInBusiness;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private byte[] logoUrl;
    private String mainOfficeLocation;
    private Integer yearsInBusiness;
    private Integer numberOfEmployees;
    private String specialization;
    private String contactEmail;
    private String websiteUrl;

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key to User
    private Users user;

    // Constructors
    public FranchisorBrand() {}

    public FranchisorBrand(String name, byte[] logoUrl, String mainOfficeLocation,
                           Integer yearsInBusiness, Integer numberOfEmployees,
                           String specialization, String contactEmail, String websiteUrl,
                           Users user) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.mainOfficeLocation = mainOfficeLocation;
        this.yearsInBusiness = yearsInBusiness;
        this.numberOfEmployees = numberOfEmployees;
        this.specialization = specialization;
        this.contactEmail = contactEmail;
        this.websiteUrl = websiteUrl;
        this.user = user;
    }

}
