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
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/"+expectedUser.getLogin()));
        //then
        getUserByLoginResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.login").value(expectedUser.getLogin()))
                .andExpect(jsonPath("$.keycloakId").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.stats").exists())
                .andExpect(jsonPath("$.equipment").exists())
                .andExpect(jsonPath("$.money").value(0))
                .andExpect(jsonPath("$._links.self").exists());
    }

    @Test
    void shouldReturnNotFoundWhileGettingUserByLogin() throws Exception {
        //given
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/notexistsuser"));
        //then
        getUserByLoginResult.andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = GET_USER_BY_KEYCLOAK_ID_USERNAME)
    void shouldGetUserByKeycloakIdWithSelfLink() throws Exception {
        //given
        User expectedUser = userCreator.createUser(GET_USER_BY_KEYCLOAK_ID_USERNAME);
        //when
        ResultActions getUserByKeycloakIdResult = mockMvc.perform(get("/users/current"));
        //then
        getUserByKeycloakIdResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.login").value(expectedUser.getLogin()))
                .andExpect(jsonPath("$.keycloakId").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.stats").exists())
                .andExpect(jsonPath("$.equipment").exists())
                .andExpect(jsonPath("$.money").value(0))
                .andExpect(jsonPath("$._links.self").exists());
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