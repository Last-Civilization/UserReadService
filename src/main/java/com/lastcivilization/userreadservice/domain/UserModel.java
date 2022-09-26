package com.lastcivilization.userreadservice.domain;

public record UserModel(
        Long id,
        String keycloakId,
        String login,
        String email,
        long stats,
        long equipment,
        long account
) {

}
