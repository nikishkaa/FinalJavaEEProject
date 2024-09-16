package org.example.finaljavaeeproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;


    @OneToMany(mappedBy = "role")
    private Set<User> users;


    public Role(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
