package org.example.finaljavaeeproject.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Entity(name = "UserPhoto")
@Getter
@Setter
@ToString
@Table(name = "user_photo")
public class UserPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "photo_order", nullable = false)
    private int photoOrder;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;
}
