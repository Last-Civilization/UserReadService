package com.lastcivilization.userreadservice.infrastructure.database;

import com.lastcivilization.userreadservice.domain.view.UserModel;
import com.lastcivilization.userreadservice.domain.exception.UserNotFoundException;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lastcivilization.userreadservice.infrastructure.database.EntityMapper.MAPPER;

@Service
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    @Cacheable("login")
    public Optional<UserModel> findByLogin(String login) {
        Optional<UserEntity> userEntity = userJpaRepository.findByLogin(login);
        return userEntity
                .map(MAPPER::toDomain);
    }

    @Override
    public Optional<UserModel> findByKeycloakId(String keycloakId) {
        Optional<UserEntity> userEntity = userJpaRepository.findByKeycloakId(keycloakId);
        return userEntity
                .map(MAPPER::toDomain);
    }

    @Override
    public UserModel save(UserModel user) {
        UserEntity userEntity = MAPPER.toEntity(user);
        UserEntity savedUserEntity = userJpaRepository.save(userEntity);
        return MAPPER.toDomain(savedUserEntity);
    }
}
