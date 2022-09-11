package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.port.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    @GetMapping("/{login}")
    ResponseEntity<EntityModel<User>> getUserByLogin(@PathVariable String login){
        User userDto = userService.findUserByLogin(login);
        return ResponseEntity.ok(EntityModel.of(userDto));
    }

    @GetMapping("/current")
    ResponseEntity<EntityModel<User>> getUserByKeycloakId(Principal principal){
        User userDto = userService.findUserByKeycloakId(principal.getName());
        return ResponseEntity.ok(EntityModel.of(userDto));
    }

    @GetMapping
    ResponseEntity<CollectionModel<User>> getAllUsers(){
        List<User> userDtoList = userService.findAll();
        return ResponseEntity.ok(CollectionModel.of(userDtoList));
    }

}
