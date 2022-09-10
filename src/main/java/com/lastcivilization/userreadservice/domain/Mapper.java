package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.dto.UserDto;

class Mapper {

    static UserDto toDto(User user){
        return new UserDto(user.getId(), user.getKeycloakId(), user.getLogin(), user.getEmail(), user.getStats(), user.getEquipment());
    }
}
