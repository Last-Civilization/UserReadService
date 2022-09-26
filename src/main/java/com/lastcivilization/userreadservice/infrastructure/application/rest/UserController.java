package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.UserService;
import com.lastcivilization.userreadservice.domain.view.UserModel;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserDto;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.UserSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.lastcivilization.userreadservice.infrastructure.application.rest.RestMapper.MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    @GetMapping("/{login}/search")
    UserSearchDto getUserByLogin(@PathVariable String login){
        UserModel user = userService.findUserByLogin(login);
        return MAPPER.toSearchDto(user);
    }


    @GetMapping("/{keycloakId}")
    UserDto getUserByKeycloakId(@PathVariable String keycloakId){
        UserModel user = userService.findUserByKeycloakId(keycloakId);
        return MAPPER.toDto(user);
    }
}
