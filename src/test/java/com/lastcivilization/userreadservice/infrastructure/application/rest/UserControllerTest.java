package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.utils.IntegrationBaseClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends IntegrationBaseClass {


    private static final String GET_USER_BY_KEYCLOAK_ID_USERNAME = "shouldGetUserByKeycloakId";

    @Test
    void shouldGetUserByLoginWithSelfLink() throws Exception {
        //given
        User expectedUser = userCreator.createUser("shouldGetUserByLogin");
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/"+expectedUser.getLogin()+"/search"));
        //then
        getUserByLoginResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.keycloakId").value(expectedUser.getKeycloakId()))
                .andExpect(jsonPath("$.login").value(expectedUser.getLogin()))
                .andExpect(jsonPath("$.stats").value(expectedUser.getStats()))
                .andExpect(jsonPath("$.equipment").value(expectedUser.getEquipment()))
                .andExpect(jsonPath("$.money").doesNotExist())
                .andExpect(jsonPath("$._links.self").exists());
    }

    @Test
    void shouldGetUserByKeycloakIdWithSelfLink() throws Exception {
        //given
        User expectedUser = userCreator.createUser("shouldGetUserByKeycloakId");
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/"+expectedUser.getKeycloakId()));
        //then
        getUserByLoginResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.keycloakId").value(expectedUser.getKeycloakId()))
                .andExpect(jsonPath("$.login").value(expectedUser.getLogin()))
                .andExpect(jsonPath("$.email").value(expectedUser.getEmail()))
                .andExpect(jsonPath("$.stats").value(expectedUser.getStats()))
                .andExpect(jsonPath("$.equipment").value(expectedUser.getEquipment()))
                .andExpect(jsonPath("$.money").value(expectedUser.getMoney()))
                .andExpect(jsonPath("$._links.self").exists());
    }

    @Test
    void shouldReturnNotFoundWhileGettingUserByLogin() throws Exception {
        //given
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/notexistsuser/search"));
        //then
        getUserByLoginResult.andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnNotFoundWhileGettingUserByKeycloakId() throws Exception {
        //given
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/notexistsuser"));
        //then
        getUserByLoginResult.andExpect(status().isNotFound());
    }

    @Test
    void shouldGetAllUsersWithSelfLink() throws Exception {
        //given
        //when
        ResultActions getAllResult = mockMvc.perform(get("/users"));
        //then
        getAllResult.andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists());
    }
}