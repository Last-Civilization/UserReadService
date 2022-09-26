package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserDto;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserSearchDto;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.port.UserService;

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findUserByKeycloakId(String keycloakId) {
        return userRepository.findByKeycloakId(keycloakId);
    }
}
