package org.example.finaljavaeeproject.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.example.finaljavaeeproject.entity.announcement.HorseAnnouncement;

import java.util.Set;

@NoArgsConstructor
@Data
@Setter
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "country", nullable = false, length = 56)
    private String country;

    @Column(name = "region", nullable = false, length = 56)
    private String region;


    @OneToMany(mappedBy = "address")
    private Set<User> users;

    @OneToMany(mappedBy = "address")
    private Set<HorseAnnouncement> announcements;
}
