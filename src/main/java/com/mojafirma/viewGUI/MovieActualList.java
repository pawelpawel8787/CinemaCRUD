package com.mojafirma.viewGUI;

import com.mojafirma.model.dao.MovieDAOImplement;
import com.mojafirma.utility.MovieListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MovieActualList extends JFrame {
    private JPanel mainPanel;
    private JList movieList;
    private JButton menuButton;
    private JButton adminPanelButton;

    public MovieActualList() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        initMovieList();


        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CRUDMovieShowing();
                dispose();
            }
        });
        adminPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseAdminClient();
                dispose();
            }
        });
    }

    public void initMovieList() {
        MovieDAOImplement movieDAOImplement = new MovieDAOImplement();

        movieList.setModel(new MovieListModel(movieDAOImplement.getMovieList()));
    }
}


