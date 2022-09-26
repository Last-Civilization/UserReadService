package com.lastcivilization.userreadservice.domain.vo;

public record UserVO(
        Long id,
        String keycloakId,
        String login,
        String email,
        long stats,
        long equipment,
        long account
) {

}
