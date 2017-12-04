package com.mojafirma.viewGUI;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.MovieDAOImplement;
import com.mojafirma.model.dao.ShowingDAOImplement;
import com.mojafirma.utility.ComboBoxModelInit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ShowingCreate extends JFrame {
    private JComboBox movieComboBox;
    private JTextField DateTimeField;
    private JTextField hallNumberField;
    private JButton backToMenuButton;
    private JButton addShowingButton;
    private JButton backToAdminPanelButton;
    private JPanel mainPanel;

    public ShowingCreate() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        initBox();

        addShowingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowingDAOImplement showingDAOImplement = new ShowingDAOImplement();
                Showing showing = new Showing();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                Movie movie = (Movie) movieComboBox.getSelectedItem();

                showing.setMovie(movie);
                showing.setFilm_starts(LocalDateTime.parse(DateTimeField.getText(), dateTimeFormatter));
                showing.setCinema_hall_number(Integer.parseInt(hallNumberField.getText()));

                showingDAOImplement.addShowing(showing);
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

