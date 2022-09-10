package com.lastcivilization.userreadservice.infrastructure.application.database;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
    Optional<UserEntity> findByKeycloakId(String keycloakId);
}
