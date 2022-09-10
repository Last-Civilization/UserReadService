package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.dto.UserDto;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.port.UserService;

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserDto findUserByKeycloakId(String keycloakId) {
        return userRepository.findByKeycloakId(keycloakId);
    }
}
