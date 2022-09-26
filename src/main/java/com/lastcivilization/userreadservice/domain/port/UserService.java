package com.lastcivilization.userreadservice.domain.port;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.vo.UserVO;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserDto;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserSearchDto;

public interface UserService {

    UserVO findUserByLogin(String login);
    UserVO findUserByKeycloakId(String keycloakId);
}
