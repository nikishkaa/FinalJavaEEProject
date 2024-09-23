package org.example.finaljavaeeproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Data
@Table(name = "horses")
public class Horses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Date age;

    @Column(name = "horse_breed", length = 128, nullable = true)
    private String horseBreed;


    // TODO связь многие ко многим с Stables


    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private HorseStatus statuss;

    @ManyToOne
    @JoinColumn(name = "user_owner_id", nullable = false)
    private User horseUserOwner;

    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;

    // TODO доделать таблицу
}
