package com.example.Real_Store.dto;

import com.example.Real_Store.entity.Product;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CustomerDTO {
    private Long customerId;
    @NotBlank(message = "Provide your firstName")
    private String firstName;
    @NotBlank(message = "Provide your lastName")
    private String lastName;
    private String phoneNo;
    @NotBlank(message = "Provide your address")
    private String address;
    @NotBlank(message = "Provide correct format")
    private String email;

    public List<Product> productList;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
