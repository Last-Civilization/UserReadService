package com.lastcivilization.userreadservice.infrastructure.application.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RestUserSearchDto {
    private String keycloakId;
    private String login;
    private Long stats;
    private Long equipment;
}
