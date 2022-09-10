package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.dto.UserDto;

class Mapper {

    static UserDto toDto(User user){
        return UserDto.Builder.anUserDto()
                .id(user.getId())
                .keycloakId(user.getKeycloakId())
                .login(user.getLogin())
                .email(user.getEmail())
                .stats(user.getStats())
                .equipment(user.getEquipment())
                .build();
    }
}
