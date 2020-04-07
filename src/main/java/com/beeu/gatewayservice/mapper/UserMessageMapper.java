package com.beeu.gatewayservice.mapper;

import com.beeu.gatewayservice.dto.User;
import com.beeu.gatewayservice.message.UserMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMessageMapper {

    @Mappings({})
    UserMessage toMessage(User user);
}
