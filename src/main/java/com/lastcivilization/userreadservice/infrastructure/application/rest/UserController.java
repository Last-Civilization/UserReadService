package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.dto.UserDto;
import com.lastcivilization.userreadservice.domain.dto.UserSearchDto;
import com.lastcivilization.userreadservice.domain.port.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    @GetMapping("/{login}/search")
    ResponseEntity<UserSearchDto> getUserByLogin(@PathVariable String login){
        UserSearchDto userDto = userService.findUserByLogin(login);
        return ResponseEntity.ok(userDto);
    }


    @GetMapping("/{keycloakId}")
    ResponseEntity<UserDto> getUserByKeycloakId(@PathVariable String keycloakId){
        UserDto userDto = userService.findUserByKeycloakId(keycloakId);
        return ResponseEntity.ok(userDto);
    }
}
