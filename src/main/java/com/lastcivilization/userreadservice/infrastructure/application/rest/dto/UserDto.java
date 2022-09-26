package com.lastcivilization.userreadservice.infrastructure.application.rest.dto;

public record UserDto (
        String keycloakId,
        String login,
        String email,
        Long stats,
        Long equipment,
        Long account
) {}
