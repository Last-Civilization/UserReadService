package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.dto.UserDto;
import com.lastcivilization.userreadservice.domain.dto.UserSearchDto;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.port.UserService;

import java.util.List;

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserSearchDto findUserByLogin(String login) {
        User user = userRepository.findByLogin(login);
        return Mapper.toSearchDto(user);
    }

    @Override
    public UserDto findUserByKeycloakId(String keycloakId) {
        User user = userRepository.findByKeycloakId(keycloakId);
        return Mapper.toDto(user);
    }
}
