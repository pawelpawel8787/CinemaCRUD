package com.mojafirma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "showing")
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showing_id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable=false)
    private Movie movie;

    @Column(name = "film_starts", nullable = false)
    private LocalDateTime film_starts;

    @Column (name = "cinema_hall_number", nullable = false)
    private int cinema_hall_number;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            mappedBy = "showing", orphanRemoval = true)
    @Column(name = "RESERVATION", nullable = false)
    private List<Reservation> reservations;



    @Override
    public String toString() {
        return movie +
                ", film_starts=" + film_starts +
                ", hall_number=" + cinema_hall_number +
                '}';
    }
}
