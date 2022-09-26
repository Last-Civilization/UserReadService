package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.vo.UserVO;
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
    public UserVO findUserByLogin(String login) {
        User user = userRepository.findByLogin(login);
        return Mapper.toVo(user);
    }

    @Override
    public UserVO findUserByKeycloakId(String keycloakId) {
        User user = userRepository.findByKeycloakId(keycloakId);
        return Mapper.toVo(user);
    }
}
