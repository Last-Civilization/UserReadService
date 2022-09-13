package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.port.UserService;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.RestUserDto;
import com.lastcivilization.userreadservice.infrastructure.application.rest.dto.RestUserSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static com.lastcivilization.userreadservice.infrastructure.application.rest.RestMapper.MAPPER;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    @GetMapping("/{login}/search")
    ResponseEntity<EntityModel<RestUserSearchDto>> getUserByLogin(@PathVariable String login){
        User user = userService.findUserByLogin(login);
        EntityModel<RestUserSearchDto> entityModel = EntityModel.of(MAPPER.toRestSearch(user));
        entityModel.add(linkTo(methodOn(UserController.class).getUserByLogin(login)).withSelfRel());
        return ResponseEntity.ok(entityModel);
    }

    @GetMapping("/{keycloakId}")
    ResponseEntity<EntityModel<RestUserDto>> getUserByKeycloakId(@PathVariable String keycloakId){
        User user = userService.findUserByKeycloakId(keycloakId);
        EntityModel<RestUserDto> entityModel = EntityModel.of(MAPPER.toRest(user));
        entityModel.add(linkTo(methodOn(UserController.class).getUserByKeycloakId(keycloakId)).withSelfRel());
        return ResponseEntity.ok(entityModel);
    }

    @GetMapping
    ResponseEntity<CollectionModel<User>> getAllUsers(){
        List<User> users = userService.findAll();
        CollectionModel<User> collectionModel = CollectionModel.of(users);
        collectionModel.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
        return ResponseEntity.ok(collectionModel);
    }

}
