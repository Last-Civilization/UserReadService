package com.lastcivilization.userreadservice.infrastructure.application.rest.dto;
public record UserSearchDto (
        String keycloakId,
        String login,
        long stats,
        long equipment
) {}
