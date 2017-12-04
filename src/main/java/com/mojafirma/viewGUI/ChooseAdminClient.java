package com.mojafirma.viewGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP on 2017-10-11.
 */
public class ChooseAdminClient extends JFrame {
    private JButton ClientButton;
    private JButton AdminButton;
    private JPanel mainPanel;

    public ChooseAdminClient() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(500, 400);
        setLocationRelativeTo(null);


        AdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminLogin();
                dispose();
            }
        });
        ClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReservationDataInput();
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        ChooseAdminClient chooseAdminClient = new ChooseAdminClient();
        chooseAdminClient.setVisible(true);
        chooseAdminClient.setSize(500, 400);
        chooseAdminClient.setLocationRelativeTo(null);

    }

}
