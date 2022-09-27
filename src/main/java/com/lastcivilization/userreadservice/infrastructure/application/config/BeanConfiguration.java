package com.lastcivilization.userreadservice.infrastructure.application.config;

import com.lastcivilization.userreadservice.domain.UserService;
import com.lastcivilization.userreadservice.domain.port.UserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.lastcivilization.userreadservice.infrastructure.database")
@EntityScan("com.lastcivilization.userreadservice.infrastructure.database")
@ComponentScan("com.lastcivilization.userreadservice")
class BeanConfiguration {

    @Bean
    UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
}
