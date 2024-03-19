package com.project.backend.model.dao;

import com.project.backend.constans.ERole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }
}
