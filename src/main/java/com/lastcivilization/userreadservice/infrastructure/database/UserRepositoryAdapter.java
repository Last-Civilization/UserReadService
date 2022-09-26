package com.lastcivilization.userreadservice.infrastructure.database;

import com.lastcivilization.userreadservice.domain.view.UserModel;
import com.lastcivilization.userreadservice.domain.exception.UserNotFoundException;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.lastcivilization.userreadservice.infrastructure.database.EntityMapper.MAPPER;

@Service
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserModel findByLogin(String login) {
        UserEntity userEntity = userJpaRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(login));
        return MAPPER.toDomain(userEntity);
    }

    @Override
    public UserModel findByKeycloakId(String keycloakId) {
        UserEntity userEntity = userJpaRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new UserNotFoundException(keycloakId));
        return MAPPER.toDomain(userEntity);
    }

    @Override
    public List<UserModel> findAll() {
        List<UserEntity> userEntities = userJpaRepository.findAll();
        return userEntities.stream()
                .map(MAPPER::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public UserModel save(UserModel user) {
        UserEntity userEntity = MAPPER.toEntity(user);
        UserEntity savedUserEntity = userJpaRepository.save(userEntity);
        return MAPPER.toDomain(savedUserEntity);
    }
}
