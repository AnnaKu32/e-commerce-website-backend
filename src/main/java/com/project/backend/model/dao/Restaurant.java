package com.project.backend.model.dao;

import com.project.backend.constans.ERole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private String name;

    //adresss
    //cordinates
    //type od restuarnt like hashtag?

    public Restaurant() {
    }

    public Restaurant(ERole name) {
        this.name = name;
    }
}

