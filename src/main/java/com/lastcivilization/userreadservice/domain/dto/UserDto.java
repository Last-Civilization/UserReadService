package com.lastcivilization.userreadservice.domain.dto;

public record UserDto (
        String keycloakId,
        String login,
        String email,
        Long stats,
        Long equipment,
        Long account
) {}
