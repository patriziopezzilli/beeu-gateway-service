package com.beeu.gatewayservice.consumer;


import com.beeu.gatewayservice.dto.User;
import com.beeu.gatewayservice.service.ApiKeyValidator;
import com.beeu.gatewayservice.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @Autowired
    private UserService userService;

    @Autowired
    private ApiKeyValidator apiKeyValidator;

    @RabbitListener(queues = "bee-create-user")
    public void createUser(User message, @Header("bee-api-key") String beekey) {
        apiKeyValidator.validate(beekey);
        System.out.println("Received a new user...");
        userService.saveUser(message, beekey);
    }

    @RabbitListener(queues = "bee-update-user")
    public void updateUser(User message, @Header("bee-api-key") String beekey) {
        apiKeyValidator.validate(beekey);
        System.out.println("Received a new user update...");
        userService.updateUser(message, beekey);
    }

    @RabbitListener(queues = "bee-activate-user")
    public void activateUser(User message, @Header("bee-api-key") String beekey) {
        apiKeyValidator.validate(beekey);
        System.out.println("Received a user activate...");
        userService.activateUser(message.getId(), beekey);
    }

    @RabbitListener(queues = "bee-deactivate-user")
    public void deactivateUser(User message, @Header("bee-api-key") String beekey) {
        apiKeyValidator.validate(beekey);
        System.out.println("Received a user deactivate...");
        userService.deactivateUser(message.getId(), beekey);
    }
}
