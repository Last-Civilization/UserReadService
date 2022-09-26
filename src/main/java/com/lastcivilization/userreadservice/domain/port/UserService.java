package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserDto;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserSearchDto;

public interface UserService {

    User findUserByLogin(String login);
    User findUserByKeycloakId(String keycloakId);
}
