package com.beeu.gatewayservice.database.repository;

import com.beeu.gatewayservice.database.entity.CustomerEntity;
import com.beeu.gatewayservice.database.entity.PlanEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository extends CrudRepository<PlanEntity, Long> {

    boolean existsByCode(String code);
}
