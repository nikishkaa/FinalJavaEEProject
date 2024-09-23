package org.example.finaljavaeeproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Data
@Table(name = "stables")
public class Stables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User userOwner;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "stable_contact_info_id", nullable = true)
    private StableContactInfo contactInfo;


    @Column(name = "horses_capacity", nullable = false)
    private int horseCapacity;

    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;

    // TODO доделать таблицу
    // TODO сделать связь многие ко многим между stable id и horse stable owner
}
