package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.dto.UserDto;

public interface UserRepository {

    UserDto findByLogin(String login);
    UserDto findByKeycloakId(String keycloakId);
}
