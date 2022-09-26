package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.view.UserModel;

public class UserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel findUserByLogin(String login) {
        UserModel userModel = userRepository.findByLogin(login);
        User user = Mapper.toDomain(userModel);
        return Mapper.toModel(user);
    }

    public UserModel findUserByKeycloakId(String keycloakId) {
        UserModel userModel = userRepository.findByKeycloakId(keycloakId);
        User user = Mapper.toDomain(userModel);
        return Mapper.toModel(user);
    }
}
