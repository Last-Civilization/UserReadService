package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.port.UserService;
import com.lastcivilization.userreadservice.domain.view.UserModel;

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel findUserByLogin(String login) {
        UserModel userModel = userRepository.findByLogin(login);
        User user = Mapper.toDomain(userModel);
        return Mapper.toModel(user);
    }

    @Override
    public UserModel findUserByKeycloakId(String keycloakId) {
        UserModel userModel = userRepository.findByKeycloakId(keycloakId);
        User user = Mapper.toDomain(userModel);
        return Mapper.toModel(user);
    }
}
