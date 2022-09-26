package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.view.UserModel;

public interface UserService {

    UserModel findUserByLogin(String login);
    UserModel findUserByKeycloakId(String keycloakId);
}
