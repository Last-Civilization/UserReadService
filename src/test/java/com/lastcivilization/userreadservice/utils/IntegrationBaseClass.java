package com.lastcivilization.userreadservice.utils;

import com.lastcivilization.userreadservice.infrastructure.application.UserReadServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = UserReadServiceApplication.class, webEnvironment = RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class IntegrationBaseClass {

    @Container
    private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:14-alpine")
            .withDatabaseName("test");

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected UserCreator userCreator;

    @DynamicPropertySource
    private static void init(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", () -> "jdbc:tc:postgresql:14-alpine:///test");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("eureka.client.register-with-eureka", () -> "false");
        registry.add("eureka.client.fetch-registry", () -> "false");
    }
}
