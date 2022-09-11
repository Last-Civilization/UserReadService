package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.User;

import java.util.List;

public interface UserRepository {

    User findByLogin(String login);
    User findByKeycloakId(String keycloakId);
    List<User> findAll();
}
