package com.lastcivilization.userreadservice.infrastructure.application.database;

import com.lastcivilization.userreadservice.domain.dto.UserDto;
import com.lastcivilization.userreadservice.domain.exception.UserNotFoundException;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.lastcivilization.userreadservice.infrastructure.application.database.EntityMapper.MAPPER;

@Component
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDto findByLogin(String login) {
        UserEntity userEntity = userJpaRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(login));
        return MAPPER.toDto(userEntity);
    }

    @Override
    public UserDto findByKeycloakId(String keycloakId) {
        UserEntity userEntity = userJpaRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new UserNotFoundException(keycloakId));
        return MAPPER.toDto(userEntity);
    }
}
