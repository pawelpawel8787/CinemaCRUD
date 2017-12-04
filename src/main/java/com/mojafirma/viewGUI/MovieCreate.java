package com.mojafirma.viewGUI;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDAOImplement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class MovieCreate extends JFrame {
    private JTextField titleField;
    private JTextField directorField;
    private JTextField durationField;
    private JTextField yearField;
    private JButton addMovieButton;
    private JLabel durationLabel;
    private JLabel directorLabel;
    private JLabel titleLabel;
    private JLabel yearLabel;
    private JPanel mainPanel;
    private JButton backToAdminPanelButton;
    private JButton backToMenuButton;

    public MovieCreate() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);


        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MovieDAOImplement movieDAOImplement = new MovieDAOImplement();
                Movie movie = new Movie();

                movie.setTitle(titleField.getText());
                movie.setDirector(directorField.getText());
                movie.setDuration(Integer.parseInt(durationField.getText()));
                movie.setYear(LocalDate.parse(yearField.getText()));

                movieDAOImplement.addMovie(movie);
            }
        });
        backToAdminPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseAdminClient();
                dispose();
            }
        });
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CRUDMovieShowing();
                dispose();
            }
        });
    }


}
