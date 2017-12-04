package com.mojafirma.viewGUI;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDAOImplement;
import com.mojafirma.utility.ComboBoxModelInit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MovieDelete extends JFrame {
    private JPanel mainPanel;
    private JComboBox movieComboBox;
    private JButton movieDeleteButton;
    private JButton menuButton;
    private JButton adminPanelButton;


    public MovieDelete() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(600, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        initBox();

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
        movieDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                MovieDAOImplement movieDAOImplement = new MovieDAOImplement();

                Movie movie = (Movie) movieComboBox.getSelectedItem();
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete " + movie + " movie from database?", "Please Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {

                    movieDAOImplement.removeMovieById(movie.getMovie_id());
                    dispose();
                    new MovieDelete();
                } else {
                    dispose();
                    new MovieDelete();
                }
            }
        });
    }

    private void initBox() {

        MovieDAOImplement movieDAOImplement = new MovieDAOImplement();

        movieComboBox.setModel(new ComboBoxModelInit(movieDAOImplement.getMovieList()));
        movieComboBox.setSelectedItem(ListSelectionModel.SINGLE_SELECTION);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new MovieDelete().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
