package com.lastcivilization.userreadservice.infrastructure.application.config;

import com.lastcivilization.userreadservice.domain.UserServiceImp;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.port.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeanConfiguration {

    @Bean
    UserService userService(UserRepository userRepository){
        return new UserServiceImp(userRepository);
    }
}
