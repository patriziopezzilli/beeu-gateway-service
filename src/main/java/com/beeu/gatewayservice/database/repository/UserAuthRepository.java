package com.beeu.gatewayservice.database.repository;

import com.beeu.gatewayservice.database.entity.UserAuthEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserAuthRepository extends CrudRepository<UserAuthEntity, Long> {

    UserAuthEntity findByIdAndPasswordOrPincode(Long id, String password, String pincode);

}
