package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserDto;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserSearchDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface RestMapper {

    RestMapper MAPPER = Mappers.getMapper(RestMapper.class);

    UserDto toDto(User user);
    UserSearchDto toSearchDto(User user);
}
