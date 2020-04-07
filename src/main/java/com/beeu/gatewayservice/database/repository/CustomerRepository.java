package com.beeu.gatewayservice.database.repository;

import com.beeu.gatewayservice.database.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByVatCode(String vatCode);

    Boolean existsByBeeId(String beeId);

    CustomerEntity findByBeeId(String beeId);
}
