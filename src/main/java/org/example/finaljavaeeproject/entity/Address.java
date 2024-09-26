package org.example.finaljavaeeproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "country", nullable = false, length = 56)
    private String country;

    @Column(name = "region", nullable = true, length = 56)
    private String region;

    @Column(name = "building", nullable = true, length = 56)
    private String building;

    @Column(name = "postcode", nullable = true, length = 20)
    private String postcode;

    @Column(name = "description", nullable = true, length = 256)
    private String description;


    @OneToMany(mappedBy = "address")
    private Set<Stables> stables;


    // TODO доделать связи и конструкторы
}
