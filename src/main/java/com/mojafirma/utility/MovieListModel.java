package com.mojafirma.utility;

import com.mojafirma.model.Movie;

import javax.swing.*;
import java.util.List;

/**
 * Created by HP on 2017-10-01.
 */
public class MovieListModel extends AbstractListModel<Movie> {

    private List<Movie> movies;

    public MovieListModel(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getSize() {
        return movies.size();
    }

    @Override
    public Movie getElementAt(int index) {
        return movies.get(index);
    }
}
