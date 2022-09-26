package com.lastcivilization.userreadservice.utils;

import com.lastcivilization.userreadservice.domain.view.UserModel;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreator {

    private final UserRepository userRepository;

    public UserModel createUser(String login){
      UserModel user = new UserModel(
              null,
              login,
              login,
              login+"@user.pl",
              0L,
              0L,
              0L
      );
      return userRepository.save(user);
    }
}
