package com.beeu.gatewayservice.controller;

import com.beeu.gatewayservice.dto.AuthResult;
import com.beeu.gatewayservice.service.ApiKeyValidator;
import com.beeu.gatewayservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/bee-u/auth")
public class AuthorizationController {

    @Autowired
    private ApiKeyValidator validator;

    @Autowired
    private AuthService authService;

    @GetMapping
    public AuthResult auth(
            @RequestHeader("bee-id") String beeId,
            @RequestHeader(value = "bee-api-key") String apiKey,
            @RequestHeader(value = "bee-password", required = false) String password,
            @RequestHeader(value = "bee-pincode", required = false) String pincode
    ) {
        validator.validate(apiKey);

        if (pincode == null && password == null) {
            throw new IllegalArgumentException("pincode or password is required.");
        }

        return authService.auth(beeId, password, pincode);
    }
}
