package com.beeu.gatewayservice.consumer;

import com.beeu.gatewayservice.dto.Customer;
import com.beeu.gatewayservice.service.CustomerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConsumer {

    @Autowired
    private CustomerService service;

    @RabbitListener(queues = "create-customer")
    public void create(Customer message) {
        System.out.println("Received a new customer creation event...");
        service.addCustomer(message);
    }

    @RabbitListener(queues = "update-customer")
    public void update(Customer message) {
        System.out.println("Received a new customer update event...");
        service.updateCustomer(message);
    }

    @RabbitListener(queues = "activate-customer")
    public void activate(Customer message) {
        System.out.println("Received a new customer activation event...");
        service.activateCustomer(message.getId());
    }

    @RabbitListener(queues = "deactivate-customer")
    public void deactivate(Customer message) {
        System.out.println("Received a new customer deactivation event...");
        service.deactivateCustomer(message.getId());
    }
}
