package com.beeu.gatewayservice.controller;

import com.beeu.gatewayservice.database.entity.CustomerEntity;
import com.beeu.gatewayservice.database.repository.CustomerRepository;
import com.beeu.gatewayservice.dto.Customer;
import com.beeu.gatewayservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/bee-u")
public class GatewayController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @PutMapping("/customer")
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }

    @PutMapping("/customer/activate")
    public void activateCustomer(@RequestBody Customer customer) {
        service.activateCustomer(customer.getId());
    }

    @PutMapping("/customer/deactivate")
    public void deactivateCustomer(@RequestBody Customer customer) {
        service.deactivateCustomer(customer.getId());
    }
}
