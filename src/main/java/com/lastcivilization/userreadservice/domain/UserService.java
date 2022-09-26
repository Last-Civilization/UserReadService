package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.exception.UserNotFoundException;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.view.UserModel;

public class UserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel findUserByLogin(String login) {
        UserModel userModel = userRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(login));
        User user = Mapper.toDomain(userModel);
        return Mapper.toModel(user);
    }

    public UserModel findUserByKeycloakId(String keycloakId) {
        UserModel userModel = userRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new UserNotFoundException(keycloakId));
        User user = Mapper.toDomain(userModel);
        return Mapper.toModel(user);
    }
}
