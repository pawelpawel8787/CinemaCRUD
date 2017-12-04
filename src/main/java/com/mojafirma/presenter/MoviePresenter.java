package com.mojafirma.presenter;

import com.mojafirma.model.Movie;

import java.util.List;


public interface MoviePresenter {

    Integer addMovie(Movie movie);

    void updateMovie(Movie movie);

    void removeMovieById(int id);

    List<Movie> getMovieList();

}
