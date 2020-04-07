package com.beeu.gatewayservice.service;

import com.beeu.gatewayservice.database.entity.UserAuthEntity;
import com.beeu.gatewayservice.database.repository.UserAuthRepository;
import com.beeu.gatewayservice.dto.AuthResult;
import com.beeu.gatewayservice.utils.BeeIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    /**
     * Main auth method
     *
     * @param beeId
     * @param password
     * @param pincode
     * @return
     */
    public AuthResult auth(String beeId, String password, String pincode) {

        /**
         * Check auth
         */
        Optional<UserAuthEntity> userAuthEntity = userAuthRepository.findById(BeeIdUtils.extractId(beeId));

        try {
            if (userAuthEntity.isPresent()
                    && (userAuthEntity.get().getPassword().equalsIgnoreCase(password)
                    || userAuthEntity.get().getPincode().equalsIgnoreCase(pincode))) {

                return new AuthResult(0, "LOGIN_SUCCESS");
            } else {
                return new AuthResult(-1, "LOGIN_FAILED");
            }
        } catch (Exception e) {
            return new AuthResult(-1, "LOGIN_FAILED");
        }
    }
}
