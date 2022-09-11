package com.lastcivilization.userreadservice.infrastructure.database;

import com.lastcivilization.userreadservice.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    UserEntity toEntity(User user);
    User toDomain(UserEntity userEntity);
}
