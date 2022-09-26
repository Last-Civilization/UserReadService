package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.UserModel;
import com.lastcivilization.userreadservice.domain.port.UserService;
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
    ResponseEntity<UserSearchDto> getUserByLogin(@PathVariable String login){
        UserModel user = userService.findUserByLogin(login);
        UserSearchDto userDto = MAPPER.toSearchDto(user);
        return ResponseEntity.ok(userDto);
    }


    @GetMapping("/{keycloakId}")
    ResponseEntity<UserDto> getUserByKeycloakId(@PathVariable String keycloakId){
        UserModel user = userService.findUserByKeycloakId(keycloakId);
        UserDto userDto = MAPPER.toDto(user);
        return ResponseEntity.ok(userDto);
    }
}
