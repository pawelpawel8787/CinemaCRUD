package com.mojafirma.viewGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CRUDMovieShowing extends JFrame {
    private JPanel mainPanel;
    private JButton addFilmButton;
    private JButton removeButton;
    private JButton updateButton;
    private JButton actualMoviesButton;
    private JButton addButton;
    private JButton removeButton1;
    private JButton updateButton1;
    private JButton actualShowingsButton;
    private JButton backToMainMenu;

    public CRUDMovieShowing() {

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(500, 400);
        setLocationRelativeTo(null);

        backToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseAdminClient();
                dispose();
            }
        });
        addFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieCreate();
                dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowingCreate();
                dispose();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieDelete();
                dispose();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieUpdate();
                dispose();
            }
        });
        actualMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieActualList();
                dispose();
            }
        });
        removeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowingDelete();
                dispose();
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowingUpdate();
                dispose();
            }
        });
        actualShowingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowingActualList();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        CRUDMovieShowing crudMovieShowing = new CRUDMovieShowing();


        crudMovieShowing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crudMovieShowing.pack();
        crudMovieShowing.setVisible(true);
        crudMovieShowing.setSize(500, 400);
        crudMovieShowing.setLocationRelativeTo(null);
    }
}
