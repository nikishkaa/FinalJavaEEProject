package org.example.finaljavaeeproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "horse_status")
public class HorseStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "statuss")
    private Set<Horses> horses;
}
