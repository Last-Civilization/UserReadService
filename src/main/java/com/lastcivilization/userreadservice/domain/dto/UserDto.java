package com.lastcivilization.userreadservice.domain.dto;

public record UserDto (Long id, String keycloakId, String login, String email, Long stats, Long equipment){ }
