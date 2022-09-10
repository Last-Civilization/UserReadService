package com.lastcivilization.userreadservice.infrastructure.application.config;

import com.lastcivilization.userreadservice.domain.UserServiceImp;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import com.lastcivilization.userreadservice.domain.port.UserService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.lastcivilization.userreadservice")
@EntityScan("com.lastcivilization.userreadservice")
@ComponentScan("com.lastcivilization.userreadservice")
class BeanConfiguration {

    @Bean
    UserService userService(UserRepository userRepository){
        return new UserServiceImp(userRepository);
    }
}
