package com.lastcivilization.userreadservice.infrastructure.application.rest;

import com.lastcivilization.userreadservice.domain.view.UserModel;
import com.lastcivilization.userreadservice.utils.IntegrationBaseClass;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends IntegrationBaseClass {

    @Test
    void shouldGetUserByLogin() throws Exception {
        //given
        UserModel expectedUser = userCreator.createUser("shouldGetUserByLogin");
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/"+expectedUser.login()+"/search"));
        //then
        getUserByLoginResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.keycloakId").exists())
                .andExpect(jsonPath("$.login").value(expectedUser.login()))
                .andExpect(jsonPath("$.stats").value(expectedUser.stats()))
                .andExpect(jsonPath("$.equipment").value(expectedUser.equipment()));
    }

    @Test
    void shouldGetUserByKeycloakIdWith() throws Exception {
        //given
        UserModel expectedUser = userCreator.createUser("shouldGetUserByKeycloakId");
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/"+expectedUser.keycloakId()));
        //then
        getUserByLoginResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.keycloakId").value(expectedUser.keycloakId()))
                .andExpect(jsonPath("$.login").value(expectedUser.login()))
                .andExpect(jsonPath("$.email").value(expectedUser.email()))
                .andExpect(jsonPath("$.stats").value(expectedUser.stats()))
                .andExpect(jsonPath("$.equipment").value(expectedUser.equipment()))
                .andExpect(jsonPath("$.account").value(expectedUser.account()));
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
}