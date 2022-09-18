package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.dto.UserDto;
import com.lastcivilization.userreadservice.domain.dto.UserSearchDto;

class Mapper {

    static UserDto toDto(User user){
        return new UserDto(
                user.getKeycloakId(),
                user.getLogin(),
                user.getEmail(),
                user.getStats(),
                user.getEquipment(),
                user.getAccount()
        );
    }

    static UserSearchDto toSearchDto(User user){
        return new UserSearchDto(
                user.getKeycloakId(),
                user.getLogin(),
                user.getStats(),
                user.getEquipment()
        );
    }

}
