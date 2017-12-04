package com.mojafirma.viewGUI;

import lombok.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class AdminLogin extends JFrame{
    private JPanel mainPanel;
    private JButton button1;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JLabel loginLabel;

    private String login = "";
    private String password = "";


    public AdminLogin(){

        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 200);
        setLocationRelativeTo(null);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginField.getText().equals(login)  && passwordField.getText().equals(password)){
                    new CRUDMovieShowing();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Try again!");
                }
            }
        });
    }


    public static void main(String[] args) {
        AdminLogin login = new AdminLogin();
        login.setVisible(true);
        login.setSize(400,300);
    }
}
