package com.mojafirma.viewGUI;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDAOImplement;
import com.mojafirma.utility.ComboBoxModelInit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MovieUpdate extends JFrame {
    private JPanel mainPanel;
    private JComboBox movieComboBox;
    private JButton backToMenuButton;
    private JButton updateMovieButton;
    private JButton backToAdminPanelButton;
    private JTextField titleFIeld;
    private JTextField directorFIeld;
    private JTextField durationField;
    private JTextField yearField;

    public MovieUpdate() {


        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        initBox();


        movieComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = (Movie) movieComboBox.getSelectedItem();

                titleFIeld.setText(movie.getTitle());
                directorFIeld.setText(movie.getDirector());
                durationField.setText(Integer.toString(movie.getDuration()));
                yearField.setText(movie.getYear().toString());
            }
        });


        updateMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovieDAOImplement movieDAOImplement = new MovieDAOImplement();
                JFrame frame = new JFrame();
                Movie movie = (Movie) movieComboBox.getSelectedItem();

                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure You want to update " + movie + " ? ", "Confirm Update", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {

                    movie.setTitle(titleFIeld.getText());
                    movie.setDirector(directorFIeld.getText());
                    movie.setDuration(Integer.parseInt(durationField.getText()));
                    movie.setYear(LocalDate.parse(yearField.getText()));

                    movieDAOImplement.updateMovie(movie);
                    dispose();
                    new MovieUpdate();
                } else {
                    dispose();
                    new MovieUpdate();
                }
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

    private void initBox() {

        MovieDAOImplement movieDAOImplement = new MovieDAOImplement();

        movieComboBox.setModel(new ComboBoxModelInit(movieDAOImplement.getMovieList()));
        movieComboBox.setSelectedItem(ListSelectionModel.SINGLE_SELECTION);

    }
}
