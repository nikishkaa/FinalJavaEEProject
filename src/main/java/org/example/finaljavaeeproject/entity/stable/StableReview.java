package org.example.finaljavaeeproject.entity.stable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.finaljavaeeproject.entity.user.User;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name = "stable_review")
public class StableReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "stable_rate", nullable = false)
    private int stableRate;

    @Column(name = "comment", nullable = true, length = 1024)
    private String comment;

    @Column(name = "date", nullable = false)
    private Date date;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "stable_id", nullable = false)
    private Stable stableId;


    @Column(name = "updated_ts", nullable = true)
    private Timestamp updatedTs;
}
