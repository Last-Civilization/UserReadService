package com.lastcivilization.userreadservice.infrastructure.application.database;

import com.lastcivilization.userreadservice.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}
