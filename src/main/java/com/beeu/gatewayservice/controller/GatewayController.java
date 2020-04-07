package com.beeu.gatewayservice.controller;

import com.beeu.gatewayservice.database.entity.CustomerEntity;
import com.beeu.gatewayservice.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/test")
    public Iterable<CustomerEntity> test(){
        return repository.findAll();
    }
}
