package org.example.finaljavaeeproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "stable_contact_info")
public class StableContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "phone_number", nullable = true, length = 20)
    private String country;

    @Column(name = "email", nullable = true, length = 128)
    private String email;

    @Column(name = "description", nullable = true, length = 256)
    private String description;

    //TODO доделать связи и констрк=укторы
}
