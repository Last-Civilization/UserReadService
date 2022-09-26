package com.lastcivilization.userreadservice.domain;

class Mapper {

    static UserModel toModel(User user){
        return new UserModel(
                user.getId(),
                user.getKeycloakId(),
                user.getLogin(),
                user.getEmail(),
                user.getStats(),
                user.getEquipment(),
                user.getAccount()
        );
    }

    static User toDomain(UserModel userModel){
        return User.Builder.anUser()
                .id(userModel.id())
                .keycloakId(userModel.keycloakId())
                .login(userModel.login())
                .email(userModel.email())
                .stats(userModel.stats())
                .equipment(userModel.equipment())
                .account(userModel.account())
                .build();
    }
}
