package com.example.demo.dto;

import jakarta.validation.constraints.*;
public class EmployeeCreateRequest {
    @NotBlank
    private String name;

    @NotBlank(message = "Image URL is required")
    @Pattern(regexp = ".*\\.png$", message = "Image URL must end with .png")
    private String image;
    
    @NotBlank
    @Pattern(regexp = "男性|女性", message = "Gender must be '男性' or '女性'")
    private String gender;

    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Hire date must be in format yyyy-MM-dd")
    private String hireDate;

    @NotBlank
    @Email(message = "Invalid email format")
    private String mailAddress;

    @NotBlank
    @Pattern(regexp = "^\\d{3}-\\d{4}$", message = "Zip code must be in format 123-4567")
    private String zipCode;

    @NotBlank
    private String address;

    @NotBlank
    @Pattern(regexp = "^\\d{2,4}-\\d{2,4}-\\d{4}$", message = "Telephone must be in format 03-9876-5432")
    private String telephone;

    @NotNull
    @Min(value = 0, message = "Salary must be a positive number")
    private Integer salary;

    @NotBlank
    private String characteristics;

    @NotNull
    @Min(value = 0, message = "Dependents count must be a non-negative number")
    private Integer dependentsCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Integer getDependentsCount() {
        return dependentsCount;
    }

    public void setDependentsCount(Integer dependentsCount) {
        this.dependentsCount = dependentsCount;
    }
}