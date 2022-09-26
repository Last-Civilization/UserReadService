package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.vo.UserVO;

class Mapper {

    static UserVO toVo(User user){
        return new UserVO(
                user.getId(),
                user.getKeycloakId(),
                user.getLogin(),
                user.getEmail(),
                user.getStats(),
                user.getEquipment(),
                user.getAccount()
        );
    }
}
