package com.lastcivilization.userreadservice.domain.dto;
public record UserSearchDto (
        String keycloakId,
        String login,
        Long stats,
        Long equipment
) {}
