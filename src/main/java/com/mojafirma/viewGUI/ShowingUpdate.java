package com.mojafirma.viewGUI;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.MovieDAOImplement;
import com.mojafirma.model.dao.ShowingDAOImplement;
import com.mojafirma.utility.ComboBoxModelInit;
import com.mojafirma.utility.ComboBoxShowingModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;


public class ShowingUpdate extends JFrame {
    private JPanel mainPanel;
    private JComboBox showingComboBox;
    private JComboBox movieComboBox;
    private JTextField dateTimeField;
    private JTextField hallNumberFiled;
    private JButton menuButton;
    private JButton updateButton;
    private JButton adminButton;

    public ShowingUpdate() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        initComboBox();
        initBox();

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CRUDMovieShowing();
                dispose();
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseAdminClient();
                dispose();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                ShowingDAOImplement showingDAOImplement = new ShowingDAOImplement();
                Movie movie = (Movie) movieComboBox.getSelectedItem();

                Showing showing = (Showing) showingComboBox.getSelectedItem();


                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure You want to update " + showing + " ? ", "Confirm Update", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    showing.setMovie(movie);
                    showing.setFilm_starts(LocalDateTime.parse(dateTimeField.getText()));
                    showing.setCinema_hall_number(Integer.parseInt(hallNumberFiled.getText()));

                    showingDAOImplement.updateShowing(showing);
                    dispose();
                    new ShowingUpdate();
                } else {
                    dispose();
                    new ShowingUpdate();
                }
            }
        });

        showingComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Showing showing = (Showing) showingComboBox.getSelectedItem();

                movieComboBox.setSelectedItem(showing.getMovie().getTitle());
                dateTimeField.setText(showing.getFilm_starts().toString());
                hallNumberFiled.setText(Integer.toString(showing.getCinema_hall_number()));
            }
        });
    }

    public void initComboBox() {
        ShowingDAOImplement showingDAOImplement = new ShowingDAOImplement();

        showingComboBox.setModel(new ComboBoxShowingModel(showingDAOImplement.getShowingList()));
        showingComboBox.setSelectedItem(ListSelectionModel.SINGLE_SELECTION);
    }

    private void initBox() {

        MovieDAOImplement movieDAOImplement = new MovieDAOImplement();

        movieComboBox.setModel(new ComboBoxModelInit(movieDAOImplement.getMovieList()));
        movieComboBox.setSelectedItem(ListSelectionModel.SINGLE_SELECTION);

    }
}
