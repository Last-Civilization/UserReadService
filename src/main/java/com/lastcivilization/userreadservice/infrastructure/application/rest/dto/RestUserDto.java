package com.lastcivilization.userreadservice.infrastructure.application.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RestUserDto {
    private String keycloakId;
    private String login;
    private String email;
    private Long stats;
    private Long equipment;
    private int money;
}
