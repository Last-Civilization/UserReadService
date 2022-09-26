package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.view.UserModel;

import java.util.List;

public interface UserRepository {

    UserModel findByLogin(String login);
    UserModel findByKeycloakId(String keycloakId);
    List<UserModel> findAll();
    UserModel save(UserModel user);
}
