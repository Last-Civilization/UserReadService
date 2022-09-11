package com.lastcivilization.userreadservice.utils;

import com.lastcivilization.userreadservice.domain.User;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreator {

    private final UserRepository userRepository;

    public User createUser(String login){
      User user = User.Builder.anUser()
              .keycloakId(login)
              .login(login)
              .email(login+"@user.pl")
              .stats(0L)
              .equipment(0L)
              .build();
      return userRepository.save(user);
    }
}
