package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.User;

import java.util.List;

public interface UserService {

    User findUserByLogin(String login);
    User findUserByKeycloakId(String keycloakId);
    List<User> findAll();
}
