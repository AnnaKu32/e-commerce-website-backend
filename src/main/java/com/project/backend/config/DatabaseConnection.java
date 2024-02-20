package com.project.backend.config;

import com.project.backend.model.dao.User;
import com.project.backend.model.dto.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class DatabaseConnection{

    private static final Logger log = LoggerFactory.getLogger(DatabaseConnection.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("Bilbo",  "Baggins", "email.com","@jei")));
            log.info("Preloading " + repository.save(new User("Frodo",  "Baggins", "email.com", "fdjhdh")));
        };
    }
}