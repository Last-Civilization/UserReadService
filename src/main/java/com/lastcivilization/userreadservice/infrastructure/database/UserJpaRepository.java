package com.lastcivilization.userreadservice.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
    Optional<UserEntity> findByKeycloakId(String keycloakId);
}
