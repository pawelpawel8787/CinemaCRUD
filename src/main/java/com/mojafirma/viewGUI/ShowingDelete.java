package com.mojafirma.viewGUI;

import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.ShowingDAOImplement;
import com.mojafirma.utility.ComboBoxShowingModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShowingDelete extends JFrame {
    private JPanel mainPanel;
    private JComboBox showingComboBox;
    private JLabel showingLabel;
    private JButton menuButton;
    private JButton deleteButton;
    private JButton adminPanelButton;

    public ShowingDelete() {

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(600, 300);
        setLocationRelativeTo(null);
        initComboBox();


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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                ShowingDAOImplement showingDAOImplement = new ShowingDAOImplement();

                Showing showing = (Showing) showingComboBox.getSelectedItem();
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure You want to delete " + showing + " from database?", "Please confirm", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {

                    showingDAOImplement.removeShowing(showing);
                    dispose();
                    new ShowingDelete();
                } else {
                    dispose();
                    new ShowingDelete();
                }

            }
        });

    }

    public void initComboBox() {
        ShowingDAOImplement showingDAOImplement = new ShowingDAOImplement();

        showingComboBox.setModel(new ComboBoxShowingModel(showingDAOImplement.getShowingList()));
        showingComboBox.setSelectedItem(ListSelectionModel.SINGLE_SELECTION);
    }
}
