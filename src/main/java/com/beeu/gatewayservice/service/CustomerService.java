package com.beeu.gatewayservice.service;

import com.beeu.gatewayservice.database.entity.CustomerEntity;
import com.beeu.gatewayservice.database.repository.CustomerRepository;
import com.beeu.gatewayservice.dto.Customer;
import com.beeu.gatewayservice.utils.ApiKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {
    private ApiKeyGenerator apiKeyGenerator = new ApiKeyGenerator();

    @Autowired
    private CustomerRepository repository;

    /**
     * Deactivate customer
     *
     * @param beeId
     */
    public void deactivateCustomer(String beeId) {

        /**
         * Check if exists with beeId
         */
        if (!repository.existsByBeeId(beeId)) {
            throw new IllegalArgumentException("bee id not present");
        }
    }

    /**
     * Activate customer
     *
     * @param beeId
     */
    public void activateCustomer(String beeId) {

        /**
         * Check if exists with beeId
         */
        if (!repository.existsByBeeId(beeId)) {
            throw new IllegalArgumentException("bee id not present");
        }
    }

    /**
     * Update given customer
     *
     * @param customer
     */
    public void updateCustomer(Customer customer) {

        /**
         * Check if exists with beeId
         */
        if (!repository.existsByBeeId(customer.getId())) {
            throw new IllegalArgumentException("bee id not present");
        }

        /**
         * Update customer
         */
        CustomerEntity toUpdate = repository.findByBeeId(customer.getId());
        toUpdate.setName(customer.getName());
        toUpdate.setCategory(customer.getCategory());
        toUpdate.setNote(customer.getNote());
        toUpdate.setVatCode(customer.getVatCode());
        toUpdate.setPhonenumber(customer.getPhoneNumber());
        toUpdate.setEmail(customer.getEmail());
        toUpdate.setParent_customer(customer.getParent());
        toUpdate.setLast_update_date(new Date());
        repository.save(toUpdate);

        /**
         * Send sms / mail for verification
         */
    }

    /**
     * Add new customer
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {

        /**
         * Check if exists with same vatCode
         */
        if (repository.existsByVatCode(customer.getVatCode())) {
            throw new IllegalArgumentException("vat code already present");
        }

        /**
         * Check if exists with same mail
         */
        if (repository.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("email already present");
        }


        /**
         * Check parent if exists
         */
        if (null != customer.getParent() && !repository.existsByBeeId(customer.getParent())) {
            throw new IllegalArgumentException("parent id (bee id) not present");
        }

        /**
         * Generate api key
         */
        String apiKey = apiKeyGenerator.generate();

        /**
         * Business logic
         */
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setCategory(customer.getCategory());
        customerEntity.setApiKey(apiKey);
        customerEntity.setNote(customer.getNote());
        customerEntity.setVatCode(customer.getVatCode());
        customerEntity.setPhonenumber(customer.getPhoneNumber());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setParent_customer(customer.getParent());
        customerEntity.setActive(true);
        customerEntity.setCreation_date(new Date());
        customerEntity.setLast_update_date(new Date());
        repository.save(customerEntity);

        /**
         * Send mail with apiKey
         */
    }
}
