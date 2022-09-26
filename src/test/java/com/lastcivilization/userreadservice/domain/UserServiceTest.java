package com.lastcivilization.userreadservice.domain;

import com.lastcivilization.userreadservice.domain.exception.UserNotFoundException;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.view.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService underTest;

    @Test
    void shouldFindUserByLogin() {
        //given
        UserModel expectedUser = buildTestUser();
        Mockito.when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(expectedUser));
        //when
        UserModel userModel = underTest.findUserByLogin(anyString());
        //then
        assertThat(userModel).isEqualTo(expectedUser);
    }

    @Test
    void shouldThrowUserNotFoundExceptionWhileFindingUserByLogin() {
        //given
        Mockito.when(userRepository.findByLogin(anyString())).thenReturn(Optional.empty());
        //when
        Executable findExecutable = () -> underTest.findUserByLogin(anyString());
        //then
        assertThrows(UserNotFoundException.class, findExecutable);
    }

    private UserModel buildTestUser() {
        return new UserModel(
                null,
                "test",
                "test",
                "test@user.pl",
                0L,
                0L,
                0L
        );
    }

    @Test
    void shouldFindUserByKeycloakId() {
        //given
        UserModel expectedUser = buildTestUser();
        Mockito.when(userRepository.findByKeycloakId(anyString())).thenReturn(Optional.of(expectedUser));
        //when
        UserModel userModel = underTest.findUserByKeycloakId(anyString());
        //then
        assertThat(userModel).isEqualTo(expectedUser);
    }

    @Test
    void shouldThrowUserNotFoundExceptionWhileFindingUserByKeycloakId() {
        //given
        Mockito.when(userRepository.findByKeycloakId(anyString())).thenReturn(Optional.empty());
        //when
        Executable findExecutable = () -> underTest.findUserByKeycloakId(anyString());
        //then
        assertThrows(UserNotFoundException.class, findExecutable);
    }
}