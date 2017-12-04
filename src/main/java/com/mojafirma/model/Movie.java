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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "movie")
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            mappedBy = "movie", orphanRemoval = true)

    @Column(name = "SHOWING", nullable = false)
    private List<Showing> showings;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private LocalDate year;

    @Column(name = "duration")
    private int duration;

    @Column(name = "director")
    private String director;


    @Override
    public String toString() {
        return title;
    }
}
