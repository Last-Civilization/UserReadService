package com.lastcivilization.userreadservice.infrastructure.database;

import com.lastcivilization.userreadservice.domain.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    UserEntity toEntity(UserModel user);
    UserModel toDomain(UserEntity userEntity);
}
