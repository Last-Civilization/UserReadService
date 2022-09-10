package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.dto.UserDto;

public interface UserService {

    UserDto findUserByLogin(String login);
    UserDto findUserByKeycloakId(String keycloakId);
}
