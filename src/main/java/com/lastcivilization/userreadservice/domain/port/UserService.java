package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.dto.UserDto;
import com.lastcivilization.userreadservice.domain.dto.UserSearchDto;

import java.util.List;

public interface UserService {

    UserSearchDto findUserByLogin(String login);
    UserDto findUserByKeycloakId(String keycloakId);
}
