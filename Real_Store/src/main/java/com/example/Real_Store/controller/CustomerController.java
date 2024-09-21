package com.example.Real_Store.controller;

import com.example.Real_Store.dto.CustomerDTO;
import com.example.Real_Store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    public CustomerService customerService;


    @PostMapping("/addCustomer")
    public CustomerDTO addCustomers(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.addCustomer(customerDTO);
    }
    @GetMapping("/getCustomerById")
    public CustomerDTO getCustomer(@RequestParam("customerId") Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getCustomers(){
        return customerService.getAllCustomers();
    }
    @PostMapping("/addOrderToCustomer")
    public void addOrderToCustomer(@RequestParam("customerId") Long customerId, @RequestParam("orderId") Long orderId){
        customerService.addOrderToCustomer(customerId,orderId);
    }

    //update and delete

}
