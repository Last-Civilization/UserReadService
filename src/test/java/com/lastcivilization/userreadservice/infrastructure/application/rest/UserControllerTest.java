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


    @Test
    void shouldGetUserByLoginWithSelfLink() throws Exception {
        //given
        User expectedUser = userCreator.createUser("test");
        //when
        ResultActions getUserByLoginResult = mockMvc.perform(get("/users/"+expectedUser.getLogin()));
        //then
        getUserByLoginResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.login").value(expectedUser.getLogin()))
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
    void getUserByKeycloakId() {
        //given
        //when
        //then
    }

    @Test
    void getAllUsers() {
        //given
        //when
        //then
    }
}