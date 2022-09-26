package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.view.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<UserModel> findByLogin(String login);
    Optional<UserModel> findByKeycloakId(String keycloakId);
    UserModel save(UserModel user);
}
