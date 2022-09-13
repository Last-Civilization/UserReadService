package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.RestUserDto;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.RestUserSearchDto;
import com.lastcivilization.userreadservice.infrastructure.database.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestMapper {

    RestMapper MAPPER = Mappers.getMapper(RestMapper.class);

    RestUserDto toRest(User user);
    RestUserSearchDto toRestSearch(User user);
}
