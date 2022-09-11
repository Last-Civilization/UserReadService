package com.lastcivilization.userreadservice.infrastructure.database;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.exception.UserNotFoundException;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.lastcivilization.userreadservice.infrastructure.database.EntityMapper.MAPPER;

@Component
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User findByLogin(String login) {
        UserEntity userEntity = userJpaRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(login));
        return MAPPER.toDto(userEntity);
    }

    @Override
    public User findByKeycloakId(String keycloakId) {
        UserEntity userEntity = userJpaRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new UserNotFoundException(keycloakId));
        return MAPPER.toDto(userEntity);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userJpaRepository.findAll();
        return userEntities.stream()
                .map(MAPPER::toDto)
                .collect(Collectors.toList());
    }
}
