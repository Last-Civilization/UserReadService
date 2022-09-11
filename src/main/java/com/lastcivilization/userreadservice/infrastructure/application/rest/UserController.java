package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.port.UserService;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    @GetMapping("/{login}")
    ResponseEntity<EntityModel<User>> getUserByLogin(@PathVariable String login){
        User user = userService.findUserByLogin(login);
        EntityModel<User> entityModel = EntityModel.of(user);
        entityModel.add(linkTo(methodOn(UserController.class).getUserByLogin(login)).withSelfRel());
        return ResponseEntity.ok(entityModel);
    }

    @GetMapping("/current")
    ResponseEntity<EntityModel<User>> getUserByKeycloakId(Principal principal){
        User user = userService.findUserByKeycloakId(principal.getName());
        EntityModel<User> entityModel = EntityModel.of(user);
        entityModel.add(linkTo(methodOn(UserController.class).getUserByKeycloakId(principal)).withSelfRel());
        return ResponseEntity.ok(EntityModel.of(user));
    }

    @GetMapping
    ResponseEntity<CollectionModel<User>> getAllUsers(){
        List<User> users = userService.findAll();
        CollectionModel<User> collectionModel = CollectionModel.of(users);
        collectionModel.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
        return ResponseEntity.ok(collectionModel);
    }

}
