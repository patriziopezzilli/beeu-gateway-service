package com.beeu.gatewayservice.service;

import com.beeu.gatewayservice.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyValidator {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Validate given api key
     *
     * @param apiKey
     */
    public void validate(String apiKey) {
        if (!customerRepository.existsByApiKeyAndActive(apiKey, true)) {
            throw new IllegalArgumentException("api key is wrong!");
        }
    }
}
