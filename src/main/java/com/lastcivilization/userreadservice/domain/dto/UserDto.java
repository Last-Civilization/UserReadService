package com.lastcivilization.userreadservice.domain.dto;

import lombok.Builder;
import lombok.Getter;

public record UserDto (
        String keycloakId,
        String login,
        String email,
        Long stats,
        Long equipment,
        int money
) {}
