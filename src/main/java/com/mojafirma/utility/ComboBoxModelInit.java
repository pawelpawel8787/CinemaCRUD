package com.mojafirma.utility;

import com.mojafirma.model.Movie;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ItemListener;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.List;

/**
 * Created by HP on 2017-10-01.
 */
public class ComboBoxModelInit extends DefaultComboBoxModel<Movie> {

    private List<Movie> movies;

    public ComboBoxModelInit(List<Movie> movies) {
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
