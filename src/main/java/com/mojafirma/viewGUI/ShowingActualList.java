package com.mojafirma.viewGUI;

import com.mojafirma.model.dao.ShowingDAOImplement;
import com.mojafirma.utility.ShowingListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShowingActualList extends JFrame {
    private JList showingList;
    private JButton backToMenuButton;
    private JButton backToAdminPanelButton;
    private JPanel mainPanel;


    public ShowingActualList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        initShowingsList();


        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CRUDMovieShowing();
                dispose();
            }
        });
        backToAdminPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseAdminClient();
                dispose();
            }
        });
    }

    public void initShowingsList() {
        ShowingDAOImplement showingDAOImplement = new ShowingDAOImplement();

        showingList.setModel(new ShowingListModel(showingDAOImplement.getShowingList()));
    }
}
