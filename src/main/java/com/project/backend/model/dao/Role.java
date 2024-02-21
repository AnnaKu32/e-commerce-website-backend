package com.project.backend.model.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private String name;

    public Role() {}

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
