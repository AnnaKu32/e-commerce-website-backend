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

    private static final Logger log = LoggerFactory.getLogger(DatabaseConnectionConfig.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Bilbo",  "Baggins", "email.com","@jei")));
            log.info("Preloading " + repository.save(new User("Frodo",  "Baggins", "email.com", "fdjhdh")));
        };
    }
}