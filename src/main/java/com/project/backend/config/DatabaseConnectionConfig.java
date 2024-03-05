package com.project.backend.config;

import com.project.backend.model.dao.User;
import com.project.backend.model.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class DatabaseConnectionConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionConfig.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
//            LOGGER.info("Preloading " + repository.save(new User("John",  "Smith", "email.com","@jei")));
//            LOGGER.info("Preloading " + repository.save(new User("Thomas",  "Smith", "email.com", "fdjhdh")));
        };
    }
}