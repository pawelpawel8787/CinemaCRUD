package com.mojafirma.utility;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;

import javax.swing.*;
import java.util.List;

/**
 * Created by HP on 2017-10-07.
 */
public class ComboBoxShowingModel extends DefaultComboBoxModel<Showing> {

    private List<Showing> showing;

    public ComboBoxShowingModel(List<Showing> showing) {
        this.showing = showing;
    }

    @Override
    public int getSize() {
        return showing.size();
    }

    @Override
    public Showing getElementAt(int index) {
        return showing.get(index);
    }

}
