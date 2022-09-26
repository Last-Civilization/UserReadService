package com.lastcivilization.userreadservice.infrastructure.application.rest.dto;
public record UserSearchDto (
        String keycloakId,
        String login,
        Long stats,
        Long equipment
) {}
