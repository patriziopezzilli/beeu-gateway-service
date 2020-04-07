package com.beeu.gatewayservice.service;

import com.beeu.gatewayservice.database.entity.CustomerEntity;
import com.beeu.gatewayservice.database.entity.UserAuthEntity;
import com.beeu.gatewayservice.database.repository.CustomerRepository;
import com.beeu.gatewayservice.database.repository.UserAuthRepository;
import com.beeu.gatewayservice.dto.User;
import com.beeu.gatewayservice.mapper.UserMessageMapper;
import com.beeu.gatewayservice.message.UserMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserMessageMapper userMessageMapper;

    /**
     * Save new user
     *
     * @param user
     */
    public void saveUser(User user, String apiKey) {

        /**
         * Retrieve customer
         */
        CustomerEntity customerEntity = customerRepository.findByApiKey(apiKey);

        /**
         * Create user auth
         */
        UserAuthEntity userAuthEntity = new UserAuthEntity();
        userAuthEntity.setCustomer(customerEntity);
        userAuthEntity.setCreation_date(new Date());
        userAuthEntity.setLast_update_date(new Date());
        userAuthEntity.setPassword(user.getPassword());
        userAuthEntity.setPincode(user.getPinCode());
        userAuthEntity = userAuthRepository.save(userAuthEntity);

        /**
         * Routing other params
         */
        UserMessage userMessage = userMessageMapper.toMessage(user);
        userMessage.setId("BEE-" + userAuthEntity.getId());

        rabbitTemplate.convertAndSend("create-user", userMessage, message -> {
            message.getMessageProperties().getHeaders().put("bee-internal-key", "beeu-dev");
            return message;
        });
    }

    /**
     * Update new user
     *
     * @param user
     */
    public void updateUser(User user, String apiKey) {

        /**
         * Routing other params
         */
    }

    /**
     * Activate user
     *
     * @param beeId
     */
    public void activateUser(String beeId, String apiKey) {

        /**
         * Routing other params
         */
    }

    /**
     * Deactivate user
     *
     * @param beeId
     */
    public void deactivateUser(String beeId, String apiKey) {

        /**
         * Routing other params
         */
    }
}
